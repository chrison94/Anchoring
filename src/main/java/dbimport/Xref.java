package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="xref")
public class Xref {
	private String db;
	private String uid;
	
	@XmlElement(name="db")
    public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}
	
	@XmlElement(name="uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Xref(String db, String uid) {
		super();
		this.db = db;
		this.uid = uid;
	}

	public Xref() {
		super();
	}

	@Override
    public String toString() {
        return " uid: " + getUid() + " db: " + getDb();
    }
}