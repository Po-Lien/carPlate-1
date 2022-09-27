package idv.cpl.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the plate_type database table.
 * 
 */
@Entity
@Table(name = "plate_type")
@NamedQuery(name = "PlateTypeDTO.findAll", query = "SELECT p FROM PlateTypeDTO p")
public class PlateTypeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	public PlateTypeDTO() {
	}

	public PlateTypeDTO(String htmlValue, String htmlNM) {
		super();
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

	@Override
	public String toString() {
		return "PlateTypeDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + "]";
	}

}