package dbimport;

import java.util.List;


public class Xrefs {
	private List<Xref> xrefs;
	
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
