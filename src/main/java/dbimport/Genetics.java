package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="genetics")
public class Genetics {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementator", strategy ="increment")
	private int id;
	

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