package idv.cpl.springboot.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the page_info database table.
 * 
 */
@Entity
@Table(name="page_info")
@NamedQuery(name="PageInfoDTO.findAll", query="SELECT p FROM PageInfoDTO p")
public class PageInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to CarTypeDTO
	@ManyToOne
	@JoinColumn(name="carType")
	private CarTypeDTO carTypeBean;

	//bi-directional many-to-one association to DeptDTO
	@ManyToOne
	@JoinColumn(name="dept")
	private DeptDTO deptBean;

	//bi-directional many-to-one association to EnergyTypeDTO
	@ManyToOne
	@JoinColumn(name="energyType")
	private EnergyTypeDTO energyTypeBean;

	//bi-directional many-to-one association to NameRefDTO
	@ManyToOne
	@JoinColumn(name="nameREF")
	private NameRefDTO nameRef;

	//bi-directional many-to-one association to PlateTypeDTO
	@ManyToOne
	@JoinColumn(name="plateType")
	private PlateTypeDTO plateTypeBean;

	//bi-directional many-to-one association to StationDTO
	@ManyToOne
	@JoinColumn(name="station")
	private StationDTO stationBean;

	//bi-directional many-to-one association to WindowNoDTO
	@ManyToOne
	@JoinColumn(name="windowNo")
	private WindowNoDTO windowNoBean;

	public PageInfoDTO() {
	}

	public PageInfoDTO(Long id, CarTypeDTO carTypeBean, DeptDTO deptBean, EnergyTypeDTO energyTypeBean,
            PlateTypeDTO plateTypeBean, StationDTO stationBean, WindowNoDTO windowNoBean) {
        this.id = id;
        this.carTypeBean = carTypeBean;
        this.deptBean = deptBean;
        this.energyTypeBean = energyTypeBean;
        this.plateTypeBean = plateTypeBean;
        this.stationBean = stationBean;
        this.windowNoBean = windowNoBean;
    }

    public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarTypeDTO getCarTypeBean() {
		return this.carTypeBean;
	}

	public void setCarTypeBean(CarTypeDTO carTypeBean) {
		this.carTypeBean = carTypeBean;
	}

	public DeptDTO getDeptBean() {
		return this.deptBean;
	}

	public void setDeptBean(DeptDTO deptBean) {
		this.deptBean = deptBean;
	}

	public EnergyTypeDTO getEnergyTypeBean() {
		return this.energyTypeBean;
	}

	public void setEnergyTypeBean(EnergyTypeDTO energyTypeBean) {
		this.energyTypeBean = energyTypeBean;
	}

	public NameRefDTO getNameRef() {
		return this.nameRef;
	}

	public void setNameRef(NameRefDTO nameRef) {
		this.nameRef = nameRef;
	}

	public PlateTypeDTO getPlateTypeBean() {
		return this.plateTypeBean;
	}

	public void setPlateTypeBean(PlateTypeDTO plateTypeBean) {
		this.plateTypeBean = plateTypeBean;
	}

	public StationDTO getStationBean() {
		return this.stationBean;
	}

	public void setStationBean(StationDTO stationBean) {
		this.stationBean = stationBean;
	}

	public WindowNoDTO getWindowNoBean() {
		return this.windowNoBean;
	}

	public void setWindowNoBean(WindowNoDTO windowNoBean) {
		this.windowNoBean = windowNoBean;
	}

    @Override
    public String toString() {
        return "PageInfoDTO [id=" + id + ", carTypeBean=" + carTypeBean + ", deptBean=" + deptBean + ", energyTypeBean="
                + energyTypeBean + ", nameRef=" + nameRef + ", plateTypeBean=" + plateTypeBean + ", stationBean="
                + stationBean + ", windowNoBean=" + windowNoBean + "]";
    }

}