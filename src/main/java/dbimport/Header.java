package dbimport;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ColumnDefault;

@Entity(name="headers")
public class Header {	 
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="uid")
	@ColumnDefault("null")
	private String uid;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="accessions",joinColumns=@JoinColumn(name="fkHeaderId", nullable = true))
	private Collection<Accession> accessions;
	
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

	public Collection<Accession> getAccessions() {
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

	public Header(String uid, String createdDate, String seqRevDate, String txtRevDate, int fk_proteinEntry) {
		super();
		this.uid = uid;
		//this.accessions = accessions;
		this.createdDate = createdDate;
		this.seqRevDate = seqRevDate;
		this.txtRevDate = txtRevDate;
	}

	public Header() {
		super();
	}

	@Override
    public String toString() {
        return "uid: " + uid + " createdDate " + createdDate + " seqRevDate " + seqRevDate;
    }


	
	
}
