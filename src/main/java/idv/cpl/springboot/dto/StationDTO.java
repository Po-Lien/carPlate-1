package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@Table(name="station")
@NamedQuery(name="StationDTO.findAll", query="SELECT s FROM StationDTO s")
public class StationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="stationBean")
	private List<PageInfoDTO> pageInfos;

	//bi-directional many-to-one association to StaCarDTO
	@OneToMany(mappedBy="station")
	private List<StaCarDTO> staCars;

	//bi-directional many-to-one association to StaPltDTO
	@OneToMany(mappedBy="station")
	private List<StaPltDTO> staPlts;

	//bi-directional many-to-one association to DeptDTO
	@ManyToOne
	@JoinColumn(name="deptValue")
	private DeptDTO dept;

	//bi-directional many-to-one association to WindowNoDTO
	@OneToMany(mappedBy="station")
	private List<WindowNoDTO> windowNos;

	public StationDTO() {
	}

	public StationDTO(String htmlValue, String htmlNM) {
        this.htmlValue = htmlValue;
        this.htmlNM = htmlNM;
    }

    public String getHtmlValue() {
		return this.htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public String getHtmlNM() {
		return this.htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	public List<PageInfoDTO> getPageInfos() {
		return this.pageInfos;
	}

	public void setPageInfos(List<PageInfoDTO> pageInfos) {
		this.pageInfos = pageInfos;
	}

	public PageInfoDTO addPageInfo(PageInfoDTO pageInfo) {
		getPageInfos().add(pageInfo);
		pageInfo.setStationBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setStationBean(null);

		return pageInfo;
	}

	public List<StaCarDTO> getStaCars() {
		return this.staCars;
	}

	public void setStaCars(List<StaCarDTO> staCars) {
		this.staCars = staCars;
	}

	public StaCarDTO addStaCar(StaCarDTO staCar) {
		getStaCars().add(staCar);
		staCar.setStation(this);

		return staCar;
	}

	public StaCarDTO removeStaCar(StaCarDTO staCar) {
		getStaCars().remove(staCar);
		staCar.setStation(null);

		return staCar;
	}

	public List<StaPltDTO> getStaPlts() {
		return this.staPlts;
	}

	public void setStaPlts(List<StaPltDTO> staPlts) {
		this.staPlts = staPlts;
	}

	public StaPltDTO addStaPlt(StaPltDTO staPlt) {
		getStaPlts().add(staPlt);
		staPlt.setStation(this);

		return staPlt;
	}

	public StaPltDTO removeStaPlt(StaPltDTO staPlt) {
		getStaPlts().remove(staPlt);
		staPlt.setStation(null);

		return staPlt;
	}

	public DeptDTO getDept() {
		return this.dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public List<WindowNoDTO> getWindowNos() {
		return this.windowNos;
	}

	public void setWindowNos(List<WindowNoDTO> windowNos) {
		this.windowNos = windowNos;
	}

	public WindowNoDTO addWindowNo(WindowNoDTO windowNo) {
		getWindowNos().add(windowNo);
		windowNo.setStation(this);

		return windowNo;
	}

	public WindowNoDTO removeWindowNo(WindowNoDTO windowNo) {
		getWindowNos().remove(windowNo);
		windowNo.setStation(null);

		return windowNo;
	}

    @Override
    public String toString() {
        return "StationDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", pageInfos=" + pageInfos + ", staCars="
                + staCars + ", staPlts=" + staPlts + ", dept=" + dept + ", windowNos=" + windowNos + "]";
    }

}