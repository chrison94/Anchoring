package dbimport;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "reference")
public class reference {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@Column(name = "fkProteinEntryId")
	private int fkProteinEntryId;

	@Column(name = "contents")
	@ColumnDefault("null")
	private String contents;
	@Column(name = "note")
	@ColumnDefault("null")
	private String note;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRefInfoId", nullable = true)
	private refinfos refinfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkAccInfoId", nullable = true)
	private accinfos accinfo;

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

	public refinfos getRefinfo() {
		return refinfo;
	}

	public void setRefinfo(refinfos refinfo) {
		this.refinfo = refinfo;
	}

	public accinfos getAccinfo() {
		return accinfo;
	}

	public void setAccinfo(accinfos accinfo) {
		this.accinfo = accinfo;
	}

	public reference(String note, String contents, int fkProteinEntryId) {
		super();
//		this.refinfo = refinfo;
//		this.accinfo = accinfo;
		this.note = note;
		this.contents = contents;
		this.fkProteinEntryId = fkProteinEntryId;
	}

	public reference(int fkProteinEntryId) {
		super();
		this.fkProteinEntryId = fkProteinEntryId;
	}

	public reference() {
		super();
	}

}