package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="summary")
public class Summary {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;

	@Column(name="length")
	private String length;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Summary() {
		super();
	}

	public Summary(String length, String type, String status) {
		super();
		this.length = length;
		this.type = type;
		this.status = status;
	}

	@Override
    public String toString() {
        return "length: " + getLength() + " type:" + getType();
    }
}
