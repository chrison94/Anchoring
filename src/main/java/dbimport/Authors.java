package dbimport;

import java.util.List;


public class Authors {
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Authors(List<Author> authors) {
		super();
		this.authors = authors;
	}

	public Authors() {
		super();
	}
	
	
}
