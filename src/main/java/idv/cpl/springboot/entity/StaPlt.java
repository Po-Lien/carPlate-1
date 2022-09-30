package idv.cpl.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sta_plt database table.
 * 
 */
@Entity
@Table(name = "sta_plt")
@NamedQuery(name = "StaPltDTO.findAll", query = "SELECT s FROM StaPlt s")
public class StaPlt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "plt_value")
	private String pltValue;

	@Column(name = "sta_value")
	private String staValue;

	public StaPlt() {
	}

	public StaPlt(String pltValue, String staValue) {
		super();
		this.pltValue = pltValue;
		this.staValue = staValue;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPltValue() {
		return this.pltValue;
	}

	public void setPltValue(String pltValue) {
		this.pltValue = pltValue;
	}

	public String getStaValue() {
		return this.staValue;
	}

	public void setStaValue(String staValue) {
		this.staValue = staValue;
	}

	@Override
	public String toString() {
		return "StaPltDTO [id=" + id + ", pltValue=" + pltValue + ", staValue=" + staValue + "]";
	}

}