package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="summaries")
public class Summary {
	@Column(name="length")
	private String length;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fk_proteinEntry;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_proteinEntry() {
		return fk_proteinEntry;
	}

	public void setFk_proteinEntry(int fk_proteinEntry) {
		this.fk_proteinEntry = fk_proteinEntry;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Summary(int fk_proteinEntry) {
		super();
		this.fk_proteinEntry = fk_proteinEntry;
	}

	public Summary(String length, String type, String status, int fk_proteinEntry) {
		super();
		this.length = length;
		this.type = type;
		this.status = status;
		this.fk_proteinEntry = fk_proteinEntry;
	}

	@Override
    public String toString() {
        return "length: " + getLength() + " type:" + getType();
    }
}
