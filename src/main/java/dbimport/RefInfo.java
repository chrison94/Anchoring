package dbimport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="refinfo")
public class RefInfo {
	private Authors authors;
	private String citation;
	private String volume;
	private String year;
	private String pages;
	private String title;
	private Xrefs xrefs;
	
	@XmlElement(name="authors")
    public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}
	
	@XmlElement(name="citation")
	public String getCitation() {
		return citation;
	}

	public void setCitation(String citation) {
		this.citation = citation;
	}
	
	@XmlElement(name="volume")
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@XmlElement(name="year")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@XmlElement(name="pages")
	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	@XmlElement(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Xrefs getXrefs() {
		return xrefs;
	}

	public void setXrefs(Xrefs xrefs) {
		this.xrefs = xrefs;
	}

	public RefInfo(Authors authors, String citation, String volume, String year, String pages, String title,
			Xrefs xrefs) {
		super();
		this.authors = authors;
		this.citation = citation;
		this.volume = volume;
		this.year = year;
		this.pages = pages;
		this.title = title;
		this.xrefs = xrefs;
	}

	public RefInfo() {
		super();
	}

	@Override
    public String toString() {
        return "\nauthors: " + getAuthors() + "\ncitation " + getCitation() + "\nvolume " + 
        getVolume() + "\nyear " + getYear() + " \npages " + getPages() + "\ntitle "+ getTitle() +
        ((getXrefs() != null) ? getXrefs().toString() : "null");
    }
}
