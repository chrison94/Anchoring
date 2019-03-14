package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;


@Entity(name="proteins")
public class proteins {
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

    @Override
    public String toString() {
        return "name: "+ getName();
    }

	public proteins(String name,int fkProteinEntry) {
		super();
		this.name = name;
		if (!this.name.matches(".*[a-z].*") && !this.name.matches(".*[A-Z].*") && !this.name.matches(".[0-9].*")) { 
			this.name = "null";
		}
	}

	public proteins() {
		super();
	}	
}
