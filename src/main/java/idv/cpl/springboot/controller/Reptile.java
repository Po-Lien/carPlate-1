package idv.cpl.springboot.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Reptile {

	public static final String BROWSER_DRIVER_KEY = "webdriver.chrome.driver";
	public static final String APP_REPO_KEY = "app.repo";
	public static final String BASE_URL = "https://www.mvdis.gov.tw/m3-emv-plate/webpickno/queryPickNo#";

	public static void configBrowserDriver() {
		String basePath = System.getProperty(APP_REPO_KEY) + File.separator + "drivers" + File.separator;

		if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver.exe");
		} else if (SystemUtils.IS_OS_MAC) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver-mac");
		} else if (SystemUtils.IS_OS_LINUX) {
			System.setProperty(BROWSER_DRIVER_KEY, basePath + "chromedriver-linux");
		}

	}

	public void saveToDataBase() throws Exception {
		// 自動設定 Browser Driver
		if (System.getProperty(APP_REPO_KEY) != null) {
			configBrowserDriver();
		}

//		//設定背景執行Chrome Browser
//		ChromeOptions optionsChrome = new ChromeOptions();
//		optionsChrome.addArguments("headless");

		// 透過 Selenium 開始命令 Chrome Driver 開啟一個網頁
		WebDriver browser = new ChromeDriver();
		browser.get(BASE_URL);
		// 取得cookie
		StringBuilder sbCookie = new StringBuilder();
		for (Cookie ck : browser.manage().getCookies()) {
			sbCookie.append(ck.getName()).append('=').append(ck.getValue()).append(';');
		}

		// 程式暫停 3 秒鐘，確保瀏覽器內相關畫面已經呈現好了
		Thread.sleep(3000);

		// 接受
		try {
			if (!clickBtn("doConfirmYes();", browser)) {
				throw new Exception("找不到接受按鈕");
			}
		} catch (Exception e) {
			browser.close();
			browser.quit();
			throw e;
		}

		String[] webSelects = { "selDeptCode", "selStationCode", "selWindowNo", "selCarType", "selEnergyType",
				"selPlateType" };
		String[] plateFir = { "自用小客貨車", "租賃小客貨車", "營業小客車", "營業小貨車" };
		Map<String, List> eleMap = new HashMap();
		// 下拉選單
		for (String webSelect : webSelects) {
			List<String> webList = new ArrayList();
			int i = 0;
			List<WebElement> options = new Select(browser.findElement(By.cssSelector("#" + webSelect))).getOptions();
			for (WebElement option : options) {
				if (i != 0) {
					if ("selCarType".equals(webSelect)) {
						if ("汽車".equals(option.getText())) {
							webList.add(option.getAttribute("value"));
						} else {
							continue;
						}
					} else if ("selPlateType".equals(webSelect)) {
						List<String> keys = Arrays.asList(plateFir);
						if (keys.contains(option.getText())) {
							webList.add(option.getAttribute("value"));
						}
					} else {
						webList.add(option.getAttribute("value"));
					}
				}
				i++;
			}
			Select selWeb = new Select(browser.findElement(By.cssSelector("#" + webSelect)));
			if (!webList.isEmpty()) {
				selWeb.selectByValue(webList.get(0));
				eleMap.put(webSelect, webList);
			}
			// 程式暫停 0.5 秒鐘，確保瀏覽器內相關畫面已經呈現好了
			Thread.sleep(500);
		}

		for (Entry<String, List> entry : eleMap.entrySet()) {

		}

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
