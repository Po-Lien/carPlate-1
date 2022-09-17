package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sta_car database table.
 * 
 */
@Entity
@Table(name="sta_car")
@NamedQuery(name="StaCarDTO.findAll", query="SELECT s FROM StaCarDTO s")
public class StaCarDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to CarTypeDTO
	@ManyToOne
	@JoinColumn(name="car_value")
	private CarTypeDTO carType;

	//bi-directional many-to-one association to StationDTO
	@ManyToOne
	@JoinColumn(name="sta_value")
	private StationDTO station;

	public StaCarDTO() {
	}

	public StaCarDTO(CarTypeDTO carType, StationDTO station) {
        super();
        this.carType = carType;
        this.station = station;
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

	public StationDTO getStation() {
		return this.station;
	}

	public void setStation(StationDTO station) {
		this.station = station;
	}

    @Override
    public String toString() {
        return "StaCarDTO [id=" + id + ", carType=" + carType + ", station=" + station + "]";
    }

}