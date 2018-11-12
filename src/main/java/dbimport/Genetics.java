package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="genetics")
public class Genetics {
	private String introns;
	
	@XmlElement(name="introns")
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