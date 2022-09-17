package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eng_car database table.
 * 
 */
@Entity
@Table(name="eng_car")
@NamedQuery(name="EngCarDTO.findAll", query="SELECT e FROM EngCarDTO e")
public class EngCarDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to CarTypeDTO
	@ManyToOne
	@JoinColumn(name="car_value")
	private CarTypeDTO carType;

	//bi-directional many-to-one association to EnergyTypeDTO
	@ManyToOne
	@JoinColumn(name="eng_value")
	private EnergyTypeDTO energyType;

	public EngCarDTO() {
	}

	public EngCarDTO(CarTypeDTO carType, EnergyTypeDTO energyType) {
        this.carType = carType;
        this.energyType = energyType;
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CarTypeDTO getCarType() {
		return this.carType;
	}

	public void setCarType(CarTypeDTO carType) {
		this.carType = carType;
	}

	public EnergyTypeDTO getEnergyType() {
		return this.energyType;
	}

	public void setEnergyType(EnergyTypeDTO energyType) {
		this.energyType = energyType;
	}

    @Override
    public String toString() {
        return "EngCarDTO [id=" + id + ", carType=" + carType + ", energyType=" + energyType + "]";
    }

}