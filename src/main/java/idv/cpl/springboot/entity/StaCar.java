package idv.cpl.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sta_car database table.
 * 
 */
@Entity
@Table(name = "sta_car")
@NamedQuery(name = "StaCarDTO.findAll", query = "SELECT s FROM StaCar s")
public class StaCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "car_value")
	private String carValue;

	@Column(name = "sta_value")
	private String staValue;

	public StaCar() {
	}

	public StaCar(String carValue, String staValue) {
		super();
		this.carValue = carValue;
		this.staValue = staValue;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarValue() {
		return this.carValue;
	}

	public void setCarValue(String carValue) {
		this.carValue = carValue;
	}

	public String getStaValue() {
		return this.staValue;
	}

	public void setStaValue(String staValue) {
		this.staValue = staValue;
	}

	@Override
	public String toString() {
		return "StaCarDTO [id=" + id + ", carValue=" + carValue + ", staValue=" + staValue + "]";
	}

}