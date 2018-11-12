package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="organism")
public class Organism {
	private String source;
	private String common;
	private String formal;
	
	@XmlElement(name="source")
    public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@XmlElement(name="common")
	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	@XmlElement(name="formal")
	public String getFormal() {
		return formal;
	}

	public void setFormal(String formal) {
		this.formal = formal;
	}

	public Organism(String source, String common, String formal) {
		super();
		this.source = source;
		this.common = common;
		this.formal = formal;
	}
	
	public Organism() {
		super();
	}

	@Override
    public String toString() {
        return "source: " + getSource() + " common " + getCommon() + " formal " + getFormal();
    }
}
