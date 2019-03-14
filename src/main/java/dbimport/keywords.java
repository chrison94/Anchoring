package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity(name="keywords")

public class keywords {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="fkProteinEntryId")
	@ColumnDefault("null")
	private int fkProteinEntryId;
	
	@Column(name="name")
	@ColumnDefault("null")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkProteinEntryId() {
		return fkProteinEntryId;
	}

	public void setFkProteinEntryId(int fkProteinEntryId) {
		this.fkProteinEntryId = fkProteinEntryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public keywords(int fkProteinEntryId, String name) {
		super();
		this.fkProteinEntryId = fkProteinEntryId;
		this.name = name;
		if (!this.name.matches(".*[a-z].*") && !this.name.matches(".*[A-Z].*") && !this.name.matches(".[0-9].*")) { 
			this.name = "null";
		}
	}

	public keywords() {
		super();
	}
	
}
