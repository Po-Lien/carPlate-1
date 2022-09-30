package idv.cpl.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the car_type database table.
 * 
 */
@Entity
@Table(name = "car_type")
@NamedQuery(name = "CarTypeDTO.findAll", query = "SELECT c FROM CarType c")
public class CarType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	public CarType() {
	}

	public CarType(String htmlValue, String htmlNM) {
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
		return "CarTypeDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + "]";
	}

}