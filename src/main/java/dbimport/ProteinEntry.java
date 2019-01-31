package dbimport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity(name="proteinentries")
public class ProteinEntry{
	
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkHeaderId", nullable = true)
	private Header header;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinId", nullable = true)
	private Protein protein;
	
 	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkOrganismId", nullable = true)
	private Organism organism;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId")
	private Collection<Reference> references;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkGeneticsId"	, nullable = true)
	private Genetics genetics;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId")
	private Collection<Classification> classification;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId")
	private Collection<Keyword> keywords;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fkProteinEntryId")
	private Collection<Feature> features;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkSummaryId", updatable=false)
	private Summary summary;
	
	@Column(name="sequence")
	private String sequence;
	
    public ProteinEntry(String sequence) {
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
    
	public ProteinEntry() {
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Protein getProtein() {
		return protein;
	}
	
	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Organism getOrganism() {
		return organism;
	}

	public void setOrganism(Organism organism) {
		this.organism = organism;
	}
	public Genetics getGenetics() {
		return genetics;
	}

	public void setGenetics(Genetics genetics) {
		this.genetics = genetics;
	}
	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	public Collection<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public Collection<Classification> getClassification() {
		return classification;
	}

	
	public void setClassification(List<Classification> classification) {
		this.classification = classification;
	}


	public Collection<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}


	public Collection<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
