package dbimport;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="accinfos")
public class AccInfo {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementator", strategy ="increment")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkAccessionId")
	private Accession accession;
	
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
	
	public List<Xref> getXrefs() {
		return xrefs;
	}

	public void setXrefs(List<Xref> xrefs) {
		this.xrefs = xrefs;
	}

	public AccInfo(Accession accession,String molType, String seqSpec) {
		super();
		this.accession = accession;
		this.molType = molType;
		this.seqSpec = seqSpec;
		//this.xrefs = xrefs;
	}

	public AccInfo() {
		super();
	}


    
}
