package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organism")
public class Organism {
	@Column(name="source")
	private String source;
	@Column(name="common")
	private String common;
	@Column(name="formal")
	private String formal;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkProteinEntry")
	private int fkProteinEntry;
	
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

	public Organism(String source, String common, String formal, int fkProteinEntry) {
		super();
		this.source = source;
		this.common = common;
		this.formal = formal;
		this.fkProteinEntry = fkProteinEntry;
	}
	
	public Organism(int fkProteinEntry) {
		super();
		this.fkProteinEntry = fkProteinEntry;
	}

	@Override
    public String toString() {
        return "source: " + getSource() + " common " + getCommon() + " formal " + getFormal();
    }
}
