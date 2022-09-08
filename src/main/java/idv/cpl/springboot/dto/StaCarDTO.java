package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sta_car")
public class StaCarDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sta_value")
	private String sta_value;

	@Column(name = "car_value")
	private String car_value;

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

	public String getCar_value() {
		return car_value;
	}

	public void setCar_value(String car_value) {
		this.car_value = car_value;
	}

	@Override
	public String toString() {
		return "StaCarDTO [id=" + id + ", sta_value=" + sta_value + ", car_value=" + car_value + "]";
	}

}
