package dbimport;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;


@Entity(name="authors")
public class Author {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="name")
	@ColumnDefault("null")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author( String name) {
		super();
		this.name = name;
	}

	public Author() {
		super();
	}
}
