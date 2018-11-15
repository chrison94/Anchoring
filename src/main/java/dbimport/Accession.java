package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accessions")
public class Accession {
	@Column(name="name")
	private String name;
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkId")
	private int fkHeaderid;
	
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
	
	public int getFkAccessionsid() {
		return fkHeaderid;
	}
	
	public void setFkAccessionsid(int fkHeaderid) {
		this.fkHeaderid = fkHeaderid;
	}
	
	public Accession(String name,  int fkHeaderid) {
		super();
		this.name = name;
		this.fkHeaderid = fkHeaderid;
	}
	
	public Accession() {
		super();
	}
	
}
