package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="feature")
public class Feature {
	private String featureType;
	private String description;
	private String seqSqc;
	private String status;
	
	@XmlElement(name="feature-type")
    public String getFeatureType() {
		return featureType;
	}

	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="seq-spec")
	public String getSeqSqc() {
		return seqSqc;
	}

	public void setSeqSqc(String seqSqc) {
		this.seqSqc = seqSqc;
	}
	
	@XmlElement(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Feature(String featureType, String description, String seqSqc, String status) {
		super();
		this.featureType = featureType;
		this.description = description;
		this.seqSqc = seqSqc;
		this.status = status;
	}

	public Feature() {
		super();
	}

	@Override
    public String toString() {
        return "featureType: " + getFeatureType() + " description " + getDescription() + " seqSqc " + getSeqSqc() + " status " +getStatus();
    }
}
