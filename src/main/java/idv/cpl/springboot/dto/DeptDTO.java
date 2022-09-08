package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class DeptDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long htmlValue;

	@Column(name = "htmlNM")
    private String htmlNM;

	public Long getHtmlValue() {
		return htmlValue;
	}

	public void setHtmlValue(Long htmlValue) {
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
		return "DeptDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + "]";
	}
	
}
