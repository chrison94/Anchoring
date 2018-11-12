package dbimport;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="xrefs")
public class Xrefs {
	private List<Xref> xrefs;

	@XmlElement(name="xref")
	public List<Xref> getXrefs() {
		return xrefs;
	}

	public void setXrefs(List<Xref> xrefs) {
		this.xrefs = xrefs;
	}

	public Xrefs(List<Xref> xrefs) {
		super();
		this.xrefs = xrefs;
	}

	public Xrefs() {
		super();
	}
	
	@Override
    public String toString() {
    	String xString = "";
    	for(Xref x : getXrefs()) {
    		xString+= (x != null) ? x.toString() : "null";
    	}
    	
        return "\nXrefs: "+xString;
    }
}
