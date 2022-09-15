package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sta_plt")
public class StaPltDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public StaPltDTO(String sta_value, String plt_value) {
		this.sta_value = sta_value;
		this.plt_value = plt_value;
	}

	@Column(name = "sta_value")
	private String sta_value;

	@Column(name = "plt_value")
	private String plt_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSta_value() {
		return sta_value;
	}

	public void setSta_value(String sta_value) {
		this.sta_value = sta_value;
	}

	public String getPlt_value() {
		return plt_value;
	}

	public void setPlt_value(String plt_value) {
		this.plt_value = plt_value;
	}

	@Override
	public String toString() {
		return "StaPltDTO [id=" + id + ", sta_value=" + sta_value + ", plt_value=" + plt_value + "]";
	}

}
