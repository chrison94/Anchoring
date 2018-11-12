package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="accinfo")
public class AccInfo {
	private String accession;
	private String molType;
	private String seqSpec;
	private Xrefs xrefs;
	
	@XmlElement(name="accession")
    public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}

	@XmlElement(name="mol-type")
	public String getMolType() {
		return molType;
	}

	public void setMolType(String molType) {
		this.molType = molType;
	}
	@XmlElement(name="seq-spec")
	public String getSeqSpec() {
		return seqSpec;
	}

	public void setSeqSpec(String seqSpec) {
		this.seqSpec = seqSpec;
	}
	@XmlElement(name="xref")
	public Xrefs getXrefs() {
		return xrefs;
	}

	public void setXrefs(Xrefs xrefs) {
		this.xrefs = xrefs;
	}

	public AccInfo(String accession, String molType, String seqSpec, Xrefs xrefs) {
		super();
		this.accession = accession;
		this.molType = molType;
		this.seqSpec = seqSpec;
		this.xrefs = xrefs;
	}

	public AccInfo() {
		super();
	}

	@Override
    public String toString() {
        return "\naccession: " + this.getAccession()  + "\nMolType: " + this.getMolType()+ "\nseqSpec " + this.getSeqSpec()  
        + "\nXrefs "+ ((getXrefs() != null) ? getXrefs().toString() : "null");
    }
}
