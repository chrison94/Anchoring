package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="organism")
public class Organism {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementator", strategy ="increment")
	private int id;
	
	@Column(name="source")
	private String source;
	@Column(name="common")
	private String common;
	@Column(name="formal")
	private String formal;


	
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
	}
	
	public Organism() {
		super();
	}

	@Override
    public String toString() {
        return "source: " + getSource() + " common " + getCommon() + " formal " + getFormal();
    }
}
