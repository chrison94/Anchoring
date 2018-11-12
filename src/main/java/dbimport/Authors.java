package dbimport;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="authors")
public class Authors {
	private List<String> authors;

	@XmlElement(name = "author")
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Authors(List<String> authors) {
		super();
		this.authors = authors;
	}

	public Authors() {
		super();
	}
	
	
}
