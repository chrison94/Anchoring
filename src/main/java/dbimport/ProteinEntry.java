package dbimport;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="proteinEntries")
public class ProteinEntry{
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	private Header header;
	
	private Protein protein;
	
	private Organism organism;
	
	private List<Reference> references;
	
	private Genetics genetics;
	
	private List<Classification> classification;

	private List<Keyword> keywords;

	private List<Feature> features;
	
	private Summary summary;
	
	@Column(name="sequence")
	private String sequence;
	
    public ProteinEntry( Header header, Protein protein, Organism organism,
			List<Reference> references, Genetics genetics, List<Classification> classification, List<Keyword> keywords,
			List<Feature> features, Summary summary, String sequence) {
		super();
		this.header = header;
		this.protein = protein;
		this.organism = organism;
		this.references = references;
		this.genetics = genetics;
		this.classification = classification;
		this.keywords = keywords;
		this.features = features;
		this.summary = summary;
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


	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}


	public Genetics getGenetics() {
		return genetics;
	}

	public void setGenetics(Genetics genetics) {
		this.genetics = genetics;
	}


	public List<Classification> getClassification() {
		return classification;
	}

	
	public void setClassification(List<Classification> classification) {
		this.classification = classification;
	}


	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}


	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}


	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
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
