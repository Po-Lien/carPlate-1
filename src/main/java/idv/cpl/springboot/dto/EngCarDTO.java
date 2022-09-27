package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the eng_car database table.
 * 
 */
@Entity
@Table(name = "eng_car")
@NamedQuery(name = "EngCarDTO.findAll", query = "SELECT e FROM EngCarDTO e")
public class EngCarDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "car_value")
	private String carValue;

	@Column(name = "eng_value")
	private String engValue;

	public EngCarDTO() {
	}

	public EngCarDTO(String carValue, String engValue) {
		super();
		this.carValue = carValue;
		this.engValue = engValue;
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

	public String getEngValue() {
		return this.engValue;
	}

	public void setEngValue(String engValue) {
		this.engValue = engValue;
	}

	@Override
	public String toString() {
		return "EngCarDTO [id=" + id + ", carValue=" + carValue + ", engValue=" + engValue + "]";
	}

}