package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xrefs")
public class Xref {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkId")
	private int fkId;
	
	@Column(name="db")
	private String db;
	
	@Column(name="uid")
	private String uid;
	
    public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Xref(String db, String uid,int fkId) {
		super();
		this.db = db;
		this.uid = uid;
		this.fkId = fkId;
	}

	public Xref(int fkId) {
		super();
		this.fkId = fkId;
	}

	@Override
    public String toString() {
        return " uid: " + getUid() + " db: " + getDb();
    }
}