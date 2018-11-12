package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="reference")
public class Reference {
	private RefInfo refinfo;
	private AccInfo accinfo;	
	private String contents;
	private String note;
	
	@XmlElement(name="refinfo")
    public RefInfo getRefinfo() {
		return refinfo;
	}

	public void setRefinfo(RefInfo refinfo) {
		this.refinfo = refinfo;
	}
	
	@XmlElement(name="accinfo")
	public AccInfo getAccinfo() {
		return accinfo;
	}
	
	public void setAccinfo(AccInfo accinfo) {
		this.accinfo = accinfo;
	}

	@XmlElement(name="contents")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@XmlElement(name="note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Reference(RefInfo refinfo, AccInfo accinfo,String note,String contents) {
		super();
		this.refinfo = refinfo;
		this.accinfo = accinfo;
		this.note = note;
		this.contents = contents;
	}

	public Reference() {
		super();
	}
}