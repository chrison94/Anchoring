package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import listener.PostUpdateEventListenerImp;

@Entity(name="accessions")
@EntityListeners( PostUpdateEventListenerImp.class )
public class Accession {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="auto_increment ")
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
		if (!this.name.matches(".*[a-z].*") && !this.name.matches(".*[A-Z].*") && !this.name.matches(".[0-9].*")) { 
			this.name = "null";
		}
	}
	
	public Accession() {
		super();
		this.name = "null";
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

