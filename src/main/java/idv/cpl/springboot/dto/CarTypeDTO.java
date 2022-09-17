package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the car_type database table.
 * 
 */
@Entity
@Table(name="car_type")
@NamedQuery(name="CarTypeDTO.findAll", query="SELECT c FROM CarTypeDTO c")
public class CarTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to EngCarDTO
	@OneToMany(mappedBy="carType")
	private List<EngCarDTO> engCars;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="carTypeBean")
	private List<PageInfoDTO> pageInfos;

	//bi-directional many-to-one association to StaCarDTO
	@OneToMany(mappedBy="carType")
	private List<StaCarDTO> staCars;

	public CarTypeDTO() {
	}

	public CarTypeDTO(String htmlValue, String htmlNM) {
        this.htmlValue = htmlValue;
        this.htmlNM = htmlNM;
    }

    public String getHtmlValue() {
		return this.htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public String getHtmlNM() {
		return this.htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	public List<EngCarDTO> getEngCars() {
		return this.engCars;
	}

	public void setEngCars(List<EngCarDTO> engCars) {
		this.engCars = engCars;
	}

	public EngCarDTO addEngCar(EngCarDTO engCar) {
		getEngCars().add(engCar);
		engCar.setCarType(this);

		return engCar;
	}

	public EngCarDTO removeEngCar(EngCarDTO engCar) {
		getEngCars().remove(engCar);
		engCar.setCarType(null);

		return engCar;
	}

	public List<PageInfoDTO> getPageInfos() {
		return this.pageInfos;
	}

	public void setPageInfos(List<PageInfoDTO> pageInfos) {
		this.pageInfos = pageInfos;
	}

	public PageInfoDTO addPageInfo(PageInfoDTO pageInfo) {
		getPageInfos().add(pageInfo);
		pageInfo.setCarTypeBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setCarTypeBean(null);

		return pageInfo;
	}

	public List<StaCarDTO> getStaCars() {
		return this.staCars;
	}

	public void setStaCars(List<StaCarDTO> staCars) {
		this.staCars = staCars;
	}

	public StaCarDTO addStaCar(StaCarDTO staCar) {
		getStaCars().add(staCar);
		staCar.setCarType(this);

		return staCar;
	}

	public StaCarDTO removeStaCar(StaCarDTO staCar) {
		getStaCars().remove(staCar);
		staCar.setCarType(null);

		return staCar;
	}

    @Override
    public String toString() {
        return "CarTypeDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", engCars=" + engCars + ", pageInfos="
                + pageInfos + ", staCars=" + staCars + "]";
    }

}