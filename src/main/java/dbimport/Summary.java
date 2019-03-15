package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "summary")
public class summary {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@Column(name = "length")
	@ColumnDefault("null")
	private String length;

	@Column(name = "type")
	@ColumnDefault("null")
	private String type;

	@Column(name = "status")
	@ColumnDefault("null")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public summary() {
		super();
	}

	public summary(String length, String type, String status) {
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
