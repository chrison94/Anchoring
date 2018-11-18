package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="xrefs")
public class Xref {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementator", strategy ="increment")
	private int id;
	
	@Column(name="fkRefinfoId")
	private int fkRefinfoId;
	
	@Column(name="fkAccinfoId")
	private int fkAccinofId;
		
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

	public Xref(String db, String uid,int fkRefinfoId, int fkAccinofId) {
		super();
		this.db = db;
		this.uid = uid;
		this.fkRefinfoId = fkRefinfoId;
		this.fkAccinofId = fkAccinofId;
	}

	public Xref(int fkRefinfoId, int fkAccinofId) {
		super();
		this.fkRefinfoId = fkRefinfoId;
		this.fkAccinofId = fkAccinofId;
	}
	
	public Xref() {
		
	}

	public int getFkRefinfoId() {
		return fkRefinfoId;
	}

	public void setFkRefinfoId(int fkRefinfoId) {
		this.fkRefinfoId = fkRefinfoId;
	}
	

	public int getFkAccinofId() {
		return fkAccinofId;
	}

	public void setFkAccinofId(int fkAccinofId) {
		this.fkAccinofId = fkAccinofId;
	}
}