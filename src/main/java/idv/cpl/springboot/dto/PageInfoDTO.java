package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "page_info")
public class PageInfoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nameref")
	private Long nameREF;

	@Column(name = "dept")
	private String dept;

	@Column(name = "station")
	private String station;

	@Column(name = "windowno")
	private String windowNo;

	@Column(name = "cartype")
	private String carType;

	@Column(name = "energytype")
	private String energyType;

	@Column(name = "platetype")
	private String plateType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNameREF() {
		return nameREF;
	}

	public void setNameREF(Long nameREF) {
		this.nameREF = nameREF;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getWindowNo() {
		return windowNo;
	}

	public void setWindowNo(String windowNo) {
		this.windowNo = windowNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getEnergyType() {
		return energyType;
	}

	public void setEnergyType(String energyType) {
		this.energyType = energyType;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	@Override
	public String toString() {
		return "PageInfoDTO [id=" + id + ", nameREF=" + nameREF + ", dept=" + dept + ", station=" + station
				+ ", windowNo=" + windowNo + ", carType=" + carType + ", energyType=" + energyType + ", plateType="
				+ plateType + "]";
	}

}
