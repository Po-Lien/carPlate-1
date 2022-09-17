package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plate_type database table.
 * 
 */
@Entity
@Table(name="plate_type")
@NamedQuery(name="PlateTypeDTO.findAll", query="SELECT p FROM PlateTypeDTO p")
public class PlateTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="plateTypeBean")
	private List<PageInfoDTO> pageInfos;

	//bi-directional many-to-one association to StaPltDTO
	@OneToMany(mappedBy="plateType")
	private List<StaPltDTO> staPlts;

	public PlateTypeDTO() {
	}

	public PlateTypeDTO(String htmlValue, String htmlNM) {
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
		pageInfo.setPlateTypeBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setPlateTypeBean(null);

		return pageInfo;
	}

	public List<StaPltDTO> getStaPlts() {
		return this.staPlts;
	}

	public void setStaPlts(List<StaPltDTO> staPlts) {
		this.staPlts = staPlts;
	}

	public StaPltDTO addStaPlt(StaPltDTO staPlt) {
		getStaPlts().add(staPlt);
		staPlt.setPlateType(this);

		return staPlt;
	}

	public StaPltDTO removeStaPlt(StaPltDTO staPlt) {
		getStaPlts().remove(staPlt);
		staPlt.setPlateType(null);

		return staPlt;
	}

    @Override
    public String toString() {
        return "PlateTypeDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", pageInfos=" + pageInfos + ", staPlts="
                + staPlts + "]";
    }

}