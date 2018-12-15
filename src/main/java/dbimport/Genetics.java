package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="genetics")
public class Genetics {
	
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="introns")
	private String introns;
	
	public String getIntrons() {
		return introns;
	}

	public void setIntrons(String introns) {
		this.introns = introns;
	}
	
	public Genetics(String introns) {
		super();
		this.introns = introns;
	}
	
	public Genetics() {
		super();
	}
	
    @Override
    public String toString() {
        return "introns: "+ getIntrons();
    }
}