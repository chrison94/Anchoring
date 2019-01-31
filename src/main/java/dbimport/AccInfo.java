package dbimport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity(name="accinfos")
public class AccInfo {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkAccInfoId", nullable = true)
	private Collection<Accession> accessions;
	
	@Column(name="moltype")
	private String molType;
	
	@Column(name="seqspec")
	private String seqSpec;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkAccinfoId")
	private List<Xref> xrefs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Accession> getAccessions() {
		return accessions;
	}

	public void setAccession(Collection<Accession> accessions) {
		this.accessions = accessions;
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
	
	public List<Xref> getXrefs() {
		return xrefs;
	}

	public void setXrefs(List<Xref> xrefs) {
		this.xrefs = xrefs;
	}

	public AccInfo(Collection<Accession> accession,String molType, String seqSpec) {
		super();
		this.accessions = accession;
		this.molType = molType;
		this.seqSpec = seqSpec;
		//this.xrefs = xrefs;
	}

	public AccInfo() {
		super();
	}

}
