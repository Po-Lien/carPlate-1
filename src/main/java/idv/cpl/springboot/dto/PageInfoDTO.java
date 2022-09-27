package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the page_info database table.
 * 
 */
@Entity
@Table(name = "page_info")
@NamedQuery(name = "PageInfoDTO.findAll", query = "SELECT p FROM PageInfoDTO p")
public class PageInfoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cartypenm")
	private String carTypeNM;

	@Column(name = "cartypevalue")
	private String carTypeValue;

	@Column(name = "deptnm")
	private String deptNM;

	@Column(name = "deptvalue")
	private String deptValue;

	@Column(name = "energytypenm")
	private String energyTypeNM;

	@Column(name = "energytypevalue")
	private String energyTypeValue;

	@Column(name = "platetypenm")
	private String plateTypeNM;

	@Column(name = "platetypevalue")
	private String plateTypeValue;

	@Column(name = "stationnm")
	private String stationNM;

	@Column(name = "stationvalue")
	private String stationValue;

	@Column(name = "windownonm")
	private String windowNoNM;

	@Column(name = "windownovalue")
	private String windowNoValue;

	public PageInfoDTO() {
	}

	public PageInfoDTO(String carTypeNM, String carTypeValue, String deptNM, String deptValue, String energyTypeNM,
			String energyTypeValue, String plateTypeNM, String plateTypeValue, String stationNM, String stationValue,
			String windowNoNM, String windowNoValue) {
		super();
		this.carTypeNM = carTypeNM;
		this.carTypeValue = carTypeValue;
		this.deptNM = deptNM;
		this.deptValue = deptValue;
		this.energyTypeNM = energyTypeNM;
		this.energyTypeValue = energyTypeValue;
		this.plateTypeNM = plateTypeNM;
		this.plateTypeValue = plateTypeValue;
		this.stationNM = stationNM;
		this.stationValue = stationValue;
		this.windowNoNM = windowNoNM;
		this.windowNoValue = windowNoValue;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarTypeNM() {
		return this.carTypeNM;
	}

	public void setCarTypeNM(String carTypeNM) {
		this.carTypeNM = carTypeNM;
	}

	public String getCarTypeValue() {
		return this.carTypeValue;
	}

	public void setCarTypeValue(String carTypeValue) {
		this.carTypeValue = carTypeValue;
	}

	public String getDeptNM() {
		return this.deptNM;
	}

	public void setDeptNM(String deptNM) {
		this.deptNM = deptNM;
	}

	public String getDeptValue() {
		return this.deptValue;
	}

	public void setDeptValue(String deptValue) {
		this.deptValue = deptValue;
	}

	public String getEnergyTypeNM() {
		return this.energyTypeNM;
	}

	public void setEnergyTypeNM(String energyTypeNM) {
		this.energyTypeNM = energyTypeNM;
	}

	public String getEnergyTypeValue() {
		return this.energyTypeValue;
	}

	public void setEnergyTypeValue(String energyTypeValue) {
		this.energyTypeValue = energyTypeValue;
	}

	public String getPlateTypeNM() {
		return this.plateTypeNM;
	}

	public void setPlateTypeNM(String plateTypeNM) {
		this.plateTypeNM = plateTypeNM;
	}

	public String getPlateTypeValue() {
		return this.plateTypeValue;
	}

	public void setPlateTypeValue(String plateTypeValue) {
		this.plateTypeValue = plateTypeValue;
	}

	public String getStationNM() {
		return this.stationNM;
	}

	public void setStationNM(String stationNM) {
		this.stationNM = stationNM;
	}

	public String getStationValue() {
		return this.stationValue;
	}

	public void setStationValue(String stationValue) {
		this.stationValue = stationValue;
	}

	public String getWindowNoNM() {
		return this.windowNoNM;
	}

	public void setWindowNoNM(String windowNoNM) {
		this.windowNoNM = windowNoNM;
	}

	public String getWindowNoValue() {
		return this.windowNoValue;
	}

	public void setWindowNoValue(String windowNoValue) {
		this.windowNoValue = windowNoValue;
	}

	@Override
	public String toString() {
		return "PageInfoDTO [id=" + id + ", carTypeNM=" + carTypeNM + ", carTypeValue=" + carTypeValue + ", deptNM="
				+ deptNM + ", deptValue=" + deptValue + ", energyTypeNM=" + energyTypeNM + ", energyTypeValue="
				+ energyTypeValue + ", plateTypeNM=" + plateTypeNM + ", plateTypeValue=" + plateTypeValue
				+ ", stationNM=" + stationNM + ", stationValue=" + stationValue + ", windowNoNM=" + windowNoNM
				+ ", windowNoValue=" + windowNoValue + "]";
	}

}