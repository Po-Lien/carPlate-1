package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the window_no database table.
 * 
 */
@Entity
@Table(name="window_no")
@NamedQuery(name="WindowNoDTO.findAll", query="SELECT w FROM WindowNoDTO w")
public class WindowNoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="windowNoBean")
	private List<PageInfoDTO> pageInfos;

	//bi-directional many-to-one association to StationDTO
	@ManyToOne
	@JoinColumn(name="stationValue")
	private StationDTO station;

	public WindowNoDTO() {
	}

	public WindowNoDTO(String htmlValue, String htmlNM) {
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
		pageInfo.setWindowNoBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setWindowNoBean(null);

		return pageInfo;
	}

	public StationDTO getStation() {
		return this.station;
	}

	public void setStation(StationDTO station) {
		this.station = station;
	}

    @Override
    public String toString() {
        return "WindowNoDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", pageInfos=" + pageInfos + ", station="
                + station + "]";
    }

}