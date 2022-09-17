package idv.cpl.springboot.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the energy_type database table.
 * 
 */
@Entity
@Table(name="energy_type")
@NamedQuery(name="EnergyTypeDTO.findAll", query="SELECT e FROM EnergyTypeDTO e")
public class EnergyTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String htmlValue;

	private String htmlNM;

	//bi-directional many-to-one association to EngCarDTO
	@OneToMany(mappedBy="energyType")
	private List<EngCarDTO> engCars;

	//bi-directional many-to-one association to PageInfoDTO
	@OneToMany(mappedBy="energyTypeBean")
	private List<PageInfoDTO> pageInfos;

	public EnergyTypeDTO() {
	}

	public EnergyTypeDTO(String htmlValue, String htmlNM) {
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
		engCar.setEnergyType(this);

		return engCar;
	}

	public EngCarDTO removeEngCar(EngCarDTO engCar) {
		getEngCars().remove(engCar);
		engCar.setEnergyType(null);

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
		pageInfo.setEnergyTypeBean(this);

		return pageInfo;
	}

	public PageInfoDTO removePageInfo(PageInfoDTO pageInfo) {
		getPageInfos().remove(pageInfo);
		pageInfo.setEnergyTypeBean(null);

		return pageInfo;
	}

    @Override
    public String toString() {
        return "EnergyTypeDTO [htmlValue=" + htmlValue + ", htmlNM=" + htmlNM + ", engCars=" + engCars + ", pageInfos="
                + pageInfos + "]";
    }

}