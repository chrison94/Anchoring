package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genetics")
public class Genetics {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fk_proteinEntry;
	
	private String introns;
	
	public String getIntrons() {
		return introns;
	}

	public void setIntrons(String introns) {
		this.introns = introns;
	}
	
	public Genetics(int fkProteinEntry,String introns) {
		super();
		this.introns = introns;
		this.fk_proteinEntry = fkProteinEntry;
	}
	
	public Genetics(int fkProteinEntry) {
		super();
		this.fk_proteinEntry = fkProteinEntry;
	}
	
    @Override
    public String toString() {
        return "introns: "+ getIntrons();
    }
}