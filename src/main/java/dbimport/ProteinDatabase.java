package dbimport;

public class ProteinDatabase {
	private int id;
	private String database;

	public String getDatabase() {
		return this.database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ProteinDatabase(String database) {
		super();
		this.database = database;
	}
	
	public ProteinDatabase() {
		super();
	}
}