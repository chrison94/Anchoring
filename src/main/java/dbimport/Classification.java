package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classifications")
public class Classification {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
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

	public void setUid(int fkProteinEntryId) {
		this.fkProteinEntryId = fkProteinEntryId;
	}

	public Classification(int fkProteinEntryId,String name) {
		super();
		this.fkProteinEntryId = fkProteinEntryId;
		this.name = name;
	}
	
}
