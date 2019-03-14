package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;


@Entity(name="xrefs")
public class xrefs {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="fkRefinfoId")
	@ColumnDefault("null")
	private int fkRefinfoId;
	
	@Column(name="fkAccinfoId")
	@ColumnDefault("null")
	private int fkAccinofId;
		
	@Column(name="db")
	@ColumnDefault("null")
	private String db;
	
	@Column(name="uid")
	@ColumnDefault("null")
	private String uid;
	
    public int getId() {
		return id;
	}
    
	public int getFkRefinfoId() {
		return fkRefinfoId;
	}

	public void setFkRefinfoId(int fkRefinfoId) {
		this.fkRefinfoId = fkRefinfoId;
	}
	
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

	public int getFkAccinofId() {
		return fkAccinofId;
	}

	public void setFkAccinofId(int fkAccinofId) {
		this.fkAccinofId = fkAccinofId;
	}
	
	public xrefs(String db, String uid,int fkRefinfoId, int fkAccinofId) {
		super();
		this.db = db;
		this.uid = uid;
		this.fkRefinfoId = fkRefinfoId;
		this.fkAccinofId = fkAccinofId;
	}

	public xrefs(int fkRefinfoId, int fkAccinofId) {
		super();
		this.fkRefinfoId = fkRefinfoId;
		this.fkAccinofId = fkAccinofId;
	}
	
	public xrefs() {
		
	}
}