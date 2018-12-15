package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

@Entity(name="accessions")
public class Accession {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="fkHeaderId")
	@ColumnDefault("null")
	private int fkHeaderId;
	
	@Column(name="fkAccInfoId")
	@ColumnDefault("null")
	private int fkAccInfoId;
	
	@Column(name="name")
	@ColumnDefault("null")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Accession(String name) {
		super();
		this.name = name;
	}
	
	public Accession() {
		super();
	}

	public int getFkHeaderId() {
		return fkHeaderId;
	}

	public void setFkHeaderId(int fkHeaderId) {
		this.fkHeaderId = fkHeaderId;
	}

	public int getFkAccInfo() {
		return fkAccInfoId;
	}

	public void setFkAccInfo(int fkAccInfo) {
		this.fkAccInfoId = fkAccInfo;
	}
	
}
