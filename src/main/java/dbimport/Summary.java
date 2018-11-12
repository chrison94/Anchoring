package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="summary")
public class Summary {
	private String length;
	private String type;
	
	@XmlElement(name="length")
    public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	@XmlElement(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Summary(String length, String type) {
		super();
		this.length = length;
		this.type = type;
	}

	public Summary() {
		super();
	}


	@Override
    public String toString() {
        return "length: " + getLength() + " type:" + getType();
    }
}
