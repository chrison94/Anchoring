package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="references")
public class Reference {
	@Column(name="refinfo")
	private RefInfo refinfo;
	@Column(name="accinfo")
	private AccInfo accinfo;	
	@Column(name="contents")
	private String contents;
	@Column(name="note")
	private String note;
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fkProteinEntry;
	
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

	public int getFkProteinEntry() {
		return fkProteinEntry;
	}

	public void setFkProteinEntry(int fkProteinEntry) {
		this.fkProteinEntry = fkProteinEntry;
	}
	
	public Reference(RefInfo refinfo, AccInfo accinfo,String note,String contents, int fkProteinEntry) {
		super();
		this.refinfo = refinfo;
		this.accinfo = accinfo;
		this.note = note;
		this.contents = contents;
		this.fkProteinEntry = fkProteinEntry;
	}

	public Reference(int fkProteinEntry) {
		super();
		this.fkProteinEntry = fkProteinEntry;
	}


}