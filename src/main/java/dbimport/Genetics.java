package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;


@Entity(name="genetics")
//@EntityListeners( ListenerGenetics.class )
public class genetics {
	
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="introns")
	@ColumnDefault("null")
	private String introns;
	
	public int getId() {
		return id;
	}
	
	public String getIntrons() {
		return introns;
	}

	public void setIntrons(String introns) {
		this.introns = introns;
	}
	
	public genetics(String introns) {
		super();
		this.introns = introns;
	}
	
	public genetics() {
		super();
	}
	
    @Override
    public String toString() {
        return "introns: "+ getIntrons();
    }
}