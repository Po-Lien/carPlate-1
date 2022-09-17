package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the name_ref database table.
 * 
 */
@Entity
@Table(name="name_ref")
@NamedQuery(name="NameRefDTO.findAll", query="SELECT n FROM NameRefDTO n")
public class NameRefDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String htmlNM;

	private String htmlValue;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="nameRef")
	private List<PageInfoDTO> pageInfos;

	public NameRefDTO() {
	}

	public NameRefDTO(String htmlNM, String htmlValue) {
        this.htmlNM = htmlNM;
        this.htmlValue = htmlValue;
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHtmlNM() {
		return this.htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	public String getHtmlValue() {
		return this.htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public List<PageInfoDTO> getPageInfos() {
		return this.pageInfos;
	}

	public void setPageInfos(List<PageInfoDTO> pageInfos) {
		this.pageInfos = pageInfos;
	}

	public PageInfoDTO addPageInfo(PageInfoDTO pageInfo) {
		getPageInfos().add(pageInfo);
		pageInfo.setNameRef(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setNameRef(null);

		return pageInfo;
	}

    @Override
    public String toString() {
        return "NameRefDTO [id=" + id + ", htmlNM=" + htmlNM + ", htmlValue=" + htmlValue + ", pageInfos=" + pageInfos
                + "]";
    }

}