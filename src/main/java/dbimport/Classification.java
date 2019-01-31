package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="classifications")
public class Classification {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="fkProteinEntryId")
	private int fkProteinEntryId;
	
	@Column(name="name")
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

	public Classification(String name) {
		super();
		this.name = name;
	}
	

	public Classification() {
		super();
	}
}
