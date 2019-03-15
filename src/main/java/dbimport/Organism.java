package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "organism")
public class organism {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@Column(name = "source")
	@ColumnDefault("null")
	private String source;
	@Column(name = "common")
	@ColumnDefault("null")
	private String common;
	@Column(name = "formal")
	@ColumnDefault("null")
	private String formal;

	public int getId() {
		return id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getFormal() {
		return formal;
	}

	public void setFormal(String formal) {
		this.formal = formal;
	}

	public organism(String source, String common, String formal, int fkProteinEntry) {
		super();
		this.source = source;
		this.common = common;
		this.formal = formal;
	}

	public organism() {
		super();
	}

	@Override
	public String toString() {
		return "source: " + getSource() + " common " + getCommon() + " formal " + getFormal();
	}
}
