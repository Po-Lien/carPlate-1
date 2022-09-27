package idv.cpl.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@Table(name = "dept")
@NamedQuery(name = "DeptDTO.findAll", query = "SELECT d FROM DeptDTO d")
public class DeptDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	public DeptDTO() {
	}

	public DeptDTO(String htmlValue, String htmlNM) {
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
		return "DeptDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + "]";
	}

}