package dbimport;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="accinfos")
public class AccInfo {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkReferenceId")
	private int fkReferenceId;
	
	private Accession accession;
	
	@Column(name="moltype")
	private String molType;
	
	@Column(name="seqspec")
	private String seqSpec;
	
	private Xrefs xrefs;
	
    public int getFkReferenceId() {
		return fkReferenceId;
	}

	public void setFkReferenceId(int fkReferenceId) {
		this.fkReferenceId = fkReferenceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Accession getAccession() {
		return accession;
	}

	public void setAccession(Accession accession) {
		this.accession = accession;
	}


	public String getMolType() {
		return molType;
	}

	public void setMolType(String molType) {
		this.molType = molType;
	}

	public String getSeqSpec() {
		return seqSpec;
	}

	public void setSeqSpec(String seqSpec) {
		this.seqSpec = seqSpec;
	}
	
	public Xrefs getXrefs() {
		return xrefs;
	}

	public void setXrefs(Xrefs xrefs) {
		this.xrefs = xrefs;
	}

	public AccInfo(Accession accession, String molType, String seqSpec, Xrefs xrefs, int fkReferenceId) {
		super();
		this.accession = accession;
		this.molType = molType;
		this.seqSpec = seqSpec;
		this.xrefs = xrefs;
		this.fkReferenceId = fkReferenceId;
	}

	public AccInfo(int fkReferenceId) {
		super();
		this.fkReferenceId = fkReferenceId;
	}

	@Override
    public String toString() {
        return "\naccession: " + this.getAccession()  + "\nMolType: " + this.getMolType()+ "\nseqSpec " + this.getSeqSpec()  
        + "\nXrefs "+ ((getXrefs() != null) ? getXrefs().toString() : "null");
    }
}
