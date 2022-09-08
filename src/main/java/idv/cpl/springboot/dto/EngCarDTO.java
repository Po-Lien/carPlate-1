package idv.cpl.springboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eng_car")
public class EngCarDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "eng_value")
	private String eng_value;

	@Column(name = "car_value")
	private String car_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEng_value() {
		return eng_value;
	}

	public void setEng_value(String eng_value) {
		this.eng_value = eng_value;
	}

	public String getCar_value() {
		return car_value;
	}

	public void setCar_value(String car_value) {
		this.car_value = car_value;
	}

	@Override
	public String toString() {
		return "EngCarDTO [id=" + id + ", eng_value=" + eng_value + ", car_value=" + car_value + "]";
	}

}
