package idv.cpl.springboot.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Normal;

import idv.cpl.springboot.dto.PageInfoDTO;
import idv.cpl.springboot.repository.PageInfoRepository;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
public class PageInfoService implements IPageInfoService {

	private static final Logger log = LoggerFactory.getLogger(PageInfoService.class);

	public static final String BROWSER_DRIVER_KEY = "webdriver.chrome.driver";
	public static final String BASE_URL = "https://www.mvdis.gov.tw/m3-emv-plate/webpickno/queryPickNo#";

	private static final String[] webSelects = { "selDeptCode", "selStationCode", "selWindowNo", "selCarType",
			"selEnergyType", "selPlateType" };

	public static void configBrowserDriver() {
		String basePath = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;

		if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver.exe");
		} else if (SystemUtils.IS_OS_MAC) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver-mac");
		} else if (SystemUtils.IS_OS_LINUX) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver-linux");
		}

	}

	private final PageInfoRepository pageInfoRepository;

	private StringBuilder sb;

	private List<PageInfoDTO> pageInfoList;

	public PageInfoService(PageInfoRepository PageInfoRepository) {
		this.pageInfoRepository = PageInfoRepository;
	}

	@Override
	public PageInfoDTO save(PageInfoDTO PageInfo) {
		return pageInfoRepository.save(PageInfo);
	}

	@Override
	public void delete(PageInfoDTO PageInfo) {
		pageInfoRepository.delete(PageInfo);
	}

	@Override
	public void deleteAll() {
		pageInfoRepository.deleteAll();
	}

	@Override
	public Optional<PageInfoDTO> findById(Long id) {
		return pageInfoRepository.findById(id);
	}

	@Override
	public List<PageInfoDTO> findAll(Example arg0) {
		return pageInfoRepository.findAll(arg0);
	}

	@Override
	public List<PageInfoDTO> findAll() {
		return pageInfoRepository.findAll();
	}

	@Override
	public Page<PageInfoDTO> findAllByPageable(Pageable pageable) {
		return pageInfoRepository.findAll(pageable);
	}

	@Override
	public void saveAuto() throws Exception {
		WebDriver browser = doOpenPage();

		pageInfoList = pageInfoRepository.findAll();
		List<Map<String, String>> webList = new ArrayList();
		sb = new StringBuilder();

		this.doSelect(browser, 1, webList);
	}

	@Override
	public List<PageInfoDTO> autoFind(String[] deptValues, String plateNo) throws Exception {
		List<PageInfoDTO> pageInfoList = null;

		if (deptValues.length == 0) {
			pageInfoList = pageInfoRepository.findAll();
		} else {
			for (String value : deptValues) {
				PageInfoDTO pageInfoDTO = new PageInfoDTO();
				pageInfoDTO.setDeptValue(value);
				Example<PageInfoDTO> example = Example.of(pageInfoDTO);
				List resultList = pageInfoRepository.findAll(example);
				if (pageInfoList == null) {
					pageInfoList = resultList;
				} else {
					pageInfoList.addAll(resultList);
				}
			}
		}

		WebDriver browser = doOpenPage();

		// 取得cookie
		StringBuilder sbCookie = new StringBuilder();
		for (Cookie ck : browser.manage().getCookies()) {
			sbCookie.append(ck.getName()).append('=').append(ck.getValue()).append(';');
		}

		List<PageInfoDTO> rtnList = new ArrayList();
		for (PageInfoDTO dto : pageInfoList) {
			for (int i = 0; i < webSelects.length; i++) {
				Select selWeb = new Select(browser.findElement(By.cssSelector("#" + webSelects[i])));
				switch (i) {
				case 0:
					selWeb.selectByValue(dto.getDeptValue());
					break;
				case 1:
					selWeb.selectByValue(dto.getStationValue());
					break;
				case 2:
					selWeb.selectByValue(dto.getWindowNoValue());
					break;
				case 3:
					Thread.sleep(500);
					try {
						browser.switchTo().alert().accept();
					} catch (NoAlertPresentException Ex) {
						log.debug("no alert");
					}
					selWeb.selectByValue(dto.getCarTypeValue());
					break;
				case 4:
					selWeb.selectByValue(dto.getEnergyTypeValue());
					break;
				case 5:
					selWeb.selectByValue(dto.getPlateTypeValue());
					break;

				default:
					break;
				}
				Thread.sleep(500);
			}
			// 選擇查詢別，(預設是查詢所有)
			if (StringUtils.isNoneBlank(plateNo)) {
				List<WebElement> radioBtns = browser.findElements(By.name("queryType"));
				for (WebElement radioBtn : radioBtns) {
					String val = radioBtn.getAttribute("value");
					if ("2".equals(val)) {
						radioBtn.click();
						break;
					}
				}
				WebElement plateNoInput = browser.findElement(By.cssSelector("#queryNo"));
				plateNoInput.clear();
				if (sb != null) {
					sb.setLength(0);
				} else {
					sb = new StringBuilder();
				}
				String queryNo = sb.append('*').append(plateNo).append('*').toString();
				// 輸入傳入的車牌
				plateNoInput.sendKeys(queryNo);
			}

			// 圖形辨識
			this.doCaptcha(browser, sbCookie);

			// 判斷是否有資料
			try {
				browser.findElement(By.cssSelector("tr.empty"));
			} catch (NoSuchElementException nee) {
				// 查有資料
				log.info(dto.toString());
				rtnList.add(dto);
			}

			// 重新查詢
			clickBtn("doReturnWithData();", browser);
			Thread.sleep(8000);
		}
		return rtnList;
	}

	/**
	 * 圖形辨識
	 * 
	 * @param browser
	 * @param sbCookie
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws Exception
	 * @throws InterruptedException
	 */
	private void doCaptcha(WebDriver browser, StringBuilder sbCookie)
			throws MalformedURLException, IOException, Exception, InterruptedException {
		// 找出驗證碼輸入方塊
		WebElement captchaInput = browser.findElement(By.cssSelector("#validateStr"));
		// 圖形辨識
		while (true) {
			// 找出驗證碼的圖片元素
			WebElement captchaElement = browser.findElement(By.cssSelector("#pickimg"));
			// 換一張元素
			WebElement chgImgElement = browser.findElement(By.cssSelector("#pickimg + a"));
			chgImgElement.click();

			// 取得圖片url
			String captchaSrc = captchaElement.getAttribute("src");

			URL url = new URL(captchaSrc);
			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
			urlConn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			urlConn.setRequestProperty("Accept-Language", "zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7");
			urlConn.setRequestProperty("Host", "www.mvdis.gov.tw");
			urlConn.setRequestProperty("Referer", "https://www.mvdis.gov.tw/m3-emv-plate/webpickno/queryPickNo");
			urlConn.setRequestProperty("Cookie", sbCookie.toString());

			urlConn.connect();
			try (InputStream imgIn = urlConn.getInputStream();) {

				// Encode into Base64 URL format
				byte[] imageBytes = IOUtils.toByteArray(imgIn);
				String encodedImg = Base64.getEncoder().encodeToString(imageBytes);

				TwoCaptcha solver = new TwoCaptcha("");
				// 抓取驗證碼圖片網址
				Normal captcha = new Normal();
				captcha.setBase64(encodedImg);
				for (int i = 0; i < 20; i++) {
					try {
						// 解驗證碼
						solver.solve(captcha);
						log.info("Captcha solved: " + captcha.getCode());
						String solved = captcha.getCode();

						// 輸入驗證碼到輸入方塊
						captchaInput.clear();
						captchaInput.sendKeys(solved);
						break;
					} catch (Exception e) {
						log.info("Error occurred: " + e.getMessage());
					}
				}
			} catch (IOException ioe) {
				throw ioe;
			}

			// --------------------------------------------------確定-----------------------------------------//
			try {
				if (!clickBtn("doSubmit()", browser)) {
					throw new Exception("找不到確定按鈕!");
				}
			} catch (Exception e) {
				browser.close();
				browser.quit();
				throw e;
			}
			Thread.sleep(5000);

			// ---------------------------------------------按下確定-------------------------------------------//

			try {
				// 如果在右邊畫面有找到 "countList" 元素，代表驗證碼成功，交易資料呈現出來了。
				// 成功後要離開迴圈
				browser.findElement(By.cssSelector("table#countList"));
				break;
			} catch (NoSuchElementException e) {
				log.info("Captcha  解析失敗");
			}
		}
	}

	/**
	 * 開啟網頁
	 * 
	 * @return
	 */
	private WebDriver doOpenPage() {
		// 自動設定 Browser Driver
		configBrowserDriver();

//		//設定背景執行Chrome Browser
//		ChromeOptions optionsChrome = new ChromeOptions();
//		optionsChrome.addArguments("headless");

		// 透過 Selenium 開始命令 Chrome Driver 開啟一個網頁
		WebDriver browser = new ChromeDriver();
		browser.get(BASE_URL);

		// 程式暫停 3 秒鐘，確保瀏覽器內相關畫面已經呈現好了
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}

		// 接受
		try {
			if (!clickBtn("doConfirmYes();", browser)) {
				throw new Exception("找不到接受按鈕");
			}
		} catch (Exception e) {
			browser.close();
			browser.quit();
			log.info(e.getMessage(), e);
		}
		return browser;
	}

	/**
	 * 選擇下拉選單
	 * 
	 * @param browser
	 * @param selects
	 * @param level
	 * @param webList
	 * @throws InterruptedException
	 */
	private void doSelect(WebDriver browser, int level, List<Map<String, String>> webList) throws InterruptedException {
		String webSelect = webSelects[level - 1];
		int i = 0;
		List<WebElement> options = new Select(browser.findElement(By.cssSelector("#" + webSelect))).getOptions();

		for (WebElement option : options) {
			if (i != 0) {// 避開【請選擇】
				String val = option.getAttribute("value");// htmlValue
				String text = option.getText();// htmlNM
				Map<String, String> map = new HashMap();
				map.put(val, text);
				webList.add(map);
				Thread.sleep(500);
				Select selWeb = new Select(browser.findElement(By.cssSelector("#" + webSelect)));
				selWeb.selectByValue(val);
				if (level == 3) {
					Thread.sleep(500);
					try {
						browser.switchTo().alert().accept();
					} catch (NoAlertPresentException Ex) {
						log.debug("no alert");
					}
				}
				if (level < webSelects.length) {
					int lvl = level + 1;
					Thread.sleep(500);
					this.doSelect(browser, lvl, webList);

				} else {
					if (webList.size() == 6) {
//						for (Map<String, String> dataMap : webList) {
//							for (Entry<String, String> entry : dataMap.entrySet()) {
//								sb.append(entry.getKey()).append('，').append(entry.getValue()).append("\n");
//							}
//						}
//						log.info(sb.toString());
//						sb.setLength(0);

						// drop table & save
						if (pageInfoList != null && pageInfoList.isEmpty()) {
							PageInfoDTO dto = new PageInfoDTO();
							for (int j = 0; j < webList.size(); j++) {
								for (Entry<String, String> entry : webList.get(j).entrySet()) {
									String value = entry.getKey();
									String name = entry.getValue();
									switch (j) {
									case 0:
										dto.setDeptNM(name);
										dto.setDeptValue(value);
										break;
									case 1:
										dto.setStationNM(name);
										dto.setStationValue(value);
										break;
									case 2:
										dto.setWindowNoNM(name);
										dto.setWindowNoValue(value);
										break;
									case 3:
										dto.setCarTypeNM(name);
										dto.setCarTypeValue(value);
										break;
									case 4:
										dto.setEnergyTypeNM(name);
										dto.setEnergyTypeValue(value);
										break;
									case 5:
										dto.setPlateTypeNM(name);
										dto.setPlateTypeValue(value);
										break;

									default:
										break;
									}
								}
							}
							pageInfoRepository.save(dto);
						}

					}
				}
				webList.remove(map);
			}
			i++;
		}
		// 程式暫停 0.5 秒鐘，確保瀏覽器內相關畫面已經呈現好了
		Thread.sleep(500);
	}

	/**
	 * 點擊按鈕
	 * 
	 * @param strMethod
	 * @return
	 */
	private boolean clickBtn(String strMethod, WebDriver browser) throws Exception {
		List<WebElement> buttons = browser.findElements(By.cssSelector("a.std_btn"));
		boolean chkClick = false;
		for (WebElement button : buttons) {
			try {
				String clickMethod = button.getAttribute("onclick");

				if (strMethod.equals(clickMethod) && StringUtils.isNotBlank(button.getText())) {
					button.click();
					chkClick = true;
					break;
				}
			} catch (StaleElementReferenceException ex) {
				String clickMethod = button.getAttribute("onclick");

				if (strMethod.equals(clickMethod) && StringUtils.isNotBlank(button.getText())) {
					button.click();
					chkClick = true;
					break;
				}
			}
		}
		return chkClick;

	}
}
