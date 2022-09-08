package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_ref")
public class NameRefDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "htmlValue")
	private String htmlValue;

	@Column(name = "htmlNM")
	private String htmlNM;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHtmlValue() {
		return htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public String getHtmlNM() {
		return htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	@Override
	public String toString() {
		return "NameRefDTO [id=" + id + ", htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + "]";
	}

}
