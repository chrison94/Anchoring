package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "authors")
public class authors {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@Column(name = "name")
	@ColumnDefault("null")
	private String name;

	@Column(name = "fkRefinfoId")
	@ColumnDefault("null")
	private int fkRefinfoId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkRefinfoId() {
		return fkRefinfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public authors(String name) {
		super();
		this.name = name;
	}

	public authors() {
		super();
	}
}
