package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

@Entity(name="triggeranchor")
public class triggeranchor {
	@Id @Column(name="triggerAnchorId") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="timestamp")
	@ColumnDefault("null")
 	private String timestamp;
	
	public triggeranchor(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getId() {
		return id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}