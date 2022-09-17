package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sta_plt database table.
 * 
 */
@Entity
@Table(name="sta_plt")
@NamedQuery(name="StaPltDTO.findAll", query="SELECT s FROM StaPltDTO s")
public class StaPltDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to PlateTypeDTO
	@ManyToOne
	@JoinColumn(name="plt_value")
	private PlateTypeDTO plateType;

	//bi-directional many-to-one association to StationDTO
	@ManyToOne
	@JoinColumn(name="sta_value")
	private StationDTO station;

	public StaPltDTO() {
	}

	public StaPltDTO(PlateTypeDTO plateType, StationDTO station) {
        this.plateType = plateType;
        this.station = station;
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PlateTypeDTO getPlateType() {
		return this.plateType;
	}

	public void setPlateType(PlateTypeDTO plateType) {
		this.plateType = plateType;
	}

	public StationDTO getStation() {
		return this.station;
	}

	public void setStation(StationDTO station) {
		this.station = station;
	}

    @Override
    public String toString() {
        return "StaPltDTO [id=" + id + ", plateType=" + plateType + ", station=" + station + "]";
    }

}