package idv.cpl.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the window_no database table.
 * 
 */
@Entity
@Table(name = "window_no")
@NamedQuery(name = "WindowNoDTO.findAll", query = "SELECT w FROM WindowNoDTO w")
public class WindowNoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	private String stationValue;

	public WindowNoDTO() {
	}

	public WindowNoDTO(String htmlValue, String htmlNM, String stationValue) {
		super();
		this.htmlValue = htmlValue;
		this.htmlNM = htmlNM;
		this.stationValue = stationValue;
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

	public String getStationValue() {
		return this.stationValue;
	}

	public void setStationValue(String stationValue) {
		this.stationValue = stationValue;
	}

	@Override
	public String toString() {
		return "WindowNoDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", stationValue=" + stationValue + "]";
	}

}