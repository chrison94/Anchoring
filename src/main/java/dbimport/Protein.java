package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proteins")
public class Protein {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fkProteinEntry;
	
	@Column(name="name")
	private String name;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "name: "+ getName();
    }

	public Protein(String name,int fkProteinEntry) {
		super();
		this.name = name;
		this.fkProteinEntry = fkProteinEntry;
	}

	public Protein() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkProteinEntry() {
		return fkProteinEntry;
	}

	public void setFkProteinEntry(int fkProteinEntry) {
		this.fkProteinEntry = fkProteinEntry;
	}
	
	
	
}
