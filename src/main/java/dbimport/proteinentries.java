package dbimport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity(name="proteinentries")
public class proteinentries{
	
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkHeaderId", nullable = true)
	private headers header;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinId", nullable = true)
	private proteins protein;
	
 	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkOrganismId", nullable = true)
	private organism organism;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId", nullable = true)
	private Collection<reference> references;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkGeneticsId"	, nullable = true)
	private genetics genetics;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId", nullable = true)
	private Collection<classifications> classification;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId", nullable = true)
	private Collection<keywords> keywords;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId", nullable = true)
	private Collection<features> features;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkSummaryId", updatable=false, nullable = true)
	private summary summary;
	
	@Column(name="sequence")
	@ColumnDefault("null")
	private String sequence;
	
    public proteinentries(String sequence) {
		super();
//		this.header = header;
//		this.protein = protein;
//		this.organism = organism;
		//this.genetics = genetics;
		//this.summary = summary;
//		this.references = references;
//		this.classification = classification;
//		this.keywords = keywords;
//		this.features = features;
		this.sequence = sequence;
	}
    
	public proteinentries() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSequence() {
		return sequence;
	}
	
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}	
	
	public headers getHeader() {
		return header;
	}

	public void setHeader(headers header) {
		this.header = header;
	}

	public proteins getProtein() {
		return protein;
	}
	
	public void setProtein(proteins protein) {
		this.protein = protein;
	}

	public organism getOrganism() {
		return organism;
	}

	public void setOrganism(organism organism) {
		this.organism = organism;
	}
	public genetics getGenetics() {
		return genetics;
	}

	public void setGenetics(genetics genetics) {
		this.genetics = genetics;
	}
	public summary getSummary() {
		return summary;
	}

	public void setSummary(summary summary) {
		this.summary = summary;
	}

	public void setReferences(List<reference> references) {
		this.references = references;
	}

	public void setClassification(List<classifications> classification) {
		this.classification = classification;
	}

	public void setKeywords(List<keywords> keywords) {
		this.keywords = keywords;
	}

	public void setFeatures(List<features> features) {
		this.features = features;
	}
}
