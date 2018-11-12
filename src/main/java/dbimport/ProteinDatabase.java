package dbimport;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="ProteinDatabase")
public class ProteinDatabase {
	private String database;
	
	private List<ProteinEntry> proteinEntries;
	
	@XmlElement(name = "Database")
	public String getDatabase() {
		return this.database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	@XmlElement(name="ProteinEntry")
	public List<ProteinEntry> getProteinEntries() {
		return proteinEntries;
	}
	
	public void setProteinEntries(List<ProteinEntry> proteinEntries) {
		this.proteinEntries = proteinEntries;
	}
	
	public ProteinDatabase(String database, List<ProteinEntry> proteinEntries) {
		super();
		this.database = database;
		this.proteinEntries = proteinEntries;
	}
	
	public ProteinDatabase() {
		super();
	}
}