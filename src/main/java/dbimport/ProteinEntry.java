package dbimport;

import java.util.List;
import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement(name="ProteinEntry")
public class ProteinEntry{
	private Header header;
	
	private Protein protein;
	
	private Organism organism;
	
	private List<Reference> references;
	
	private Genetics genetics;
	
	private List<String> classification;

	private List<String> keywords;

	private List<Feature> features;
	
	private Summary summary;
	
	private String sequence;
	
    public ProteinEntry( Header header, Protein protein, Organism organism,
			List<Reference> references, Genetics genetics, List<String> classification, List<String> keywords,
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
	
	@XmlElement
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	@XmlElement
	public Protein getProtein() {
		return protein;
	}
	
	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	@XmlElement
	public Organism getOrganism() {
		return organism;
	}

	public void setOrganism(Organism organism) {
		this.organism = organism;
	}

	@XmlElement(name="reference")
	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	@XmlElement(name="genetics")
	public Genetics getGenetics() {
		return genetics;
	}

	public void setGenetics(Genetics genetics) {
		this.genetics = genetics;
	}

	@XmlElement(name="superfamily")
	public List<String> getClassification() {
		return classification;
	}

	
	public void setClassification(List<String> classification) {
		this.classification = classification;
	}

	@XmlElement(name="keyword")
	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@XmlElement
	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@XmlElement
	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	@XmlElement(name="sequence")
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	

}
