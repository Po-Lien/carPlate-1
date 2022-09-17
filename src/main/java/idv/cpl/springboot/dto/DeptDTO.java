package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@Table(name="dept")
@NamedQuery(name="DeptDTO.findAll", query="SELECT d FROM DeptDTO d")
public class DeptDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="deptBean")
	private List<PageInfoDTO> pageInfos;

	//bi-directional many-to-one association to StationDTO
	@OneToMany(mappedBy="dept")
	private List<StationDTO> stations;

	public DeptDTO() {
	}

	public DeptDTO(String htmlValue, String htmlNM) {
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
		pageInfo.setDeptBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setDeptBean(null);

		return pageInfo;
	}

	public List<StationDTO> getStations() {
		return this.stations;
	}

	public void setStations(List<StationDTO> stations) {
		this.stations = stations;
	}

	public StationDTO addStation(StationDTO station) {
		getStations().add(station);
		station.setDept(this);

		return station;
	}

	public StationDTO removeStation(StationDTO station) {
		getStations().remove(station);
		station.setDept(null);

		return station;
	}

    @Override
    public String toString() {
        return "DeptDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", pageInfos=" + pageInfos + ", stations="
                + stations + "]";
    }

}