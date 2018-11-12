package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="protein")
public class Protein {
	private String name;
	
	@XmlElement(name="name")
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

	public Protein(String name) {
		super();
		this.name = name;
	}

	public Protein() {
		super();
	}
	
	
}
