package dbimport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity(name = "accinfos")
public class accinfos {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkAccInfoId", nullable = true)
	private Collection<accessions> accessions;

	@Column(name = "moltype")
	@ColumnDefault("null")
	private String molType;

	@Column(name = "seqspec")
	@ColumnDefault("null")
	private String seqSpec;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkAccinfoId", nullable = true)
	private List<xrefs> xrefs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccession(Collection<accessions> accessions) {
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

	public void setXrefs(List<xrefs> xrefs) {
		this.xrefs = xrefs;
	}

	public accinfos(Collection<accessions> accession, String molType, String seqSpec) {
		super();
		this.accessions = accession;
		this.molType = molType;
		this.seqSpec = seqSpec;
	}

	public accinfos() {
		super();
	}

}
