package dbimport;

import java.util.List;

public class ProteinDatabase {
	private int id;
	private String database;
	
	private List<ProteinEntry> proteinEntries;
	
	public String getDatabase() {
		return this.database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public List<ProteinEntry> getProteinEntries() {
		return proteinEntries;
	}
	
	public void setProteinEntries(List<ProteinEntry> proteinEntries) {
		this.proteinEntries = proteinEntries;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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