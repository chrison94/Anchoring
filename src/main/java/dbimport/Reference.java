package dbimport;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="reference")
public class Reference {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="fkProteinEntryId")
	private int fkProteinEntryId;
	
	@Column(name="contents")
	private String contents;
	@Column(name="note")
	private String note;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkReferenceId", insertable=false, updatable=false , nullable = true)
	private RefInfo refinfo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fkReferenceId", insertable=false, updatable=false , nullable = true)
	private AccInfo accinfo;	
	
    public RefInfo getRefinfo() {
		return refinfo;
	}

	public void setRefinfo(RefInfo refinfo) {
		this.refinfo = refinfo;
	}
	
	public AccInfo getAccinfo() {
		return accinfo;
	}
	
	public void setAccinfo(AccInfo accinfo) {
		this.accinfo = accinfo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkProteinEntryId() {
		return fkProteinEntryId;
	}

	public void setFkProteinEntryId(int fkProteinEntryId) {
		this.fkProteinEntryId = fkProteinEntryId;
	}
	
	public Reference(String note,String contents, int fkProteinEntryId) {
		super();
//		this.refinfo = refinfo;
//		this.accinfo = accinfo;
		this.note = note;
		this.contents = contents;
		this.fkProteinEntryId = fkProteinEntryId;
	}

	public Reference(int fkProteinEntryId) {
		super();
		this.fkProteinEntryId = fkProteinEntryId;
	}
	
	public Reference() {
		super();
	}


}