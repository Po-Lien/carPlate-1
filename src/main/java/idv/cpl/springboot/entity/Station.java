package idv.cpl.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@Table(name = "station")
@NamedQuery(name = "StationDTO.findAll", query = "SELECT s FROM Station s")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String htmlValue;

	private String deptValue;

	private String htmlNM;

	public Station() {
	}

	public Station(String htmlValue, String htmlNM, String deptValue) {
		super();
		this.htmlValue = htmlValue;
		this.deptValue = deptValue;
		this.htmlNM = htmlNM;
	}

	public String getHtmlValue() {
		return this.htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public String getDeptValue() {
		return this.deptValue;
	}

	public void setDeptValue(String deptValue) {
		this.deptValue = deptValue;
	}

	public String getHtmlNM() {
		return this.htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	@Override
	public String toString() {
		return "StationDTO [htmlValue=" + htmlValue + ", deptValue=" + deptValue + ", htmlNM=" + htmlNM + "]";
	}

}