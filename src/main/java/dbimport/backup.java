package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnDefault;

@Entity(name="backup")
public class backup {
	@Id @Column(name="backupId") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
	@Column(name="timestamp")
	@ColumnDefault("null")
 	private String timestamp;
	
	public backup(String timestamp) {
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