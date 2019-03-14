package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;


@Entity(name="classifications")
public class classifications {
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

	public void setUid() {
	}

	public String getName() {
		return name;
	}
	public classifications(String name) {
		super();
		this.name = name;
		if (!this.name.matches(".*[a-z].*") && !this.name.matches(".*[A-Z].*") && !this.name.matches(".[0-9].*")) { 
			this.name = "null";
		}
	}
	

	public classifications() {
		super();
	}
}
