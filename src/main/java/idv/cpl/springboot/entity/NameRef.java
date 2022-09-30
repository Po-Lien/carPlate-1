package idv.cpl.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the name_ref database table.
 * 
 */
@Entity
@Table(name="name_ref")
@NamedQuery(name="NameRefDTO.findAll", query="SELECT n FROM NameRef n")
public class NameRef  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String htmlNM;

	private String htmlValue;

	private String tableNM;

	public NameRef() {
	}

	public NameRef(String htmlNM, String htmlValue, String tableNM) {
		super();
		this.htmlNM = htmlNM;
		this.htmlValue = htmlValue;
		this.tableNM = tableNM;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHtmlNM() {
		return this.htmlNM;
	}

	public void setHtmlNM(String htmlNM) {
		this.htmlNM = htmlNM;
	}

	public String getHtmlValue() {
		return this.htmlValue;
	}

	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}

	public String getTableNM() {
		return this.tableNM;
	}

	public void setTableNM(String tableNM) {
		this.tableNM = tableNM;
	}

	@Override
	public String toString() {
		return "NameRefDTO [id=" + id + ", htmlNM=" + htmlNM + ", htmlValue=" + htmlValue + ", tableNM=" + tableNM
				+ "]";
	}

}