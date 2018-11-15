package dbimport;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="headers")
public class Header {	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fk_proteinEntry;
	
	@Column(name="uid")
	private String uid;
	
	private List<Accession> accessions;
	
	@Column(name="createdDate")
	private String createdDate;
	
	@Column(name="seqRevDate")
	private String seqRevDate;
	
	@Column(name="txtRevDate")
	private String txtRevDate;
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<Accession> getAccessions() {
		return accessions;
	}

	public void setAccessions(List<Accession> accessions) {
		this.accessions = accessions;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSeqRevDate() {
		return seqRevDate;
	}

	public void setSeqRevDate(String seqRevDate) {
		this.seqRevDate = seqRevDate;
	}

	public String getTxtRevDate() {
		return txtRevDate;
	}

	public void setTxtRevDate(String txtRevDate) {
		this.txtRevDate = txtRevDate;
	}

	public Header(String uid, List<Accession> accessions, String createdDate, String seqRevDate, String txtRevDate, int fk_proteinEntry) {
		super();
		this.uid = uid;
		this.accessions = accessions;
		this.createdDate = createdDate;
		this.seqRevDate = seqRevDate;
		this.txtRevDate = txtRevDate;
		this.fk_proteinEntry = fk_proteinEntry;
	}

	public Header(int fk_proteinEntry) {
		super();
		this.fk_proteinEntry= fk_proteinEntry;
	}

	@Override
    public String toString() {
        return "uid: " + uid + " createdDate " + createdDate + " seqRevDate " + seqRevDate;
    }

	public int getFk_proteinEntry() {
		return fk_proteinEntry;
	}

	public void setFk_proteinEntry(int fk_proteinEntry) {
		this.fk_proteinEntry = fk_proteinEntry;
	}
	
	
}
