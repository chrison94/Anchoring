package dbimport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="refinfos")
public class RefInfo {
	private Authors authors;
	
	@Column(name="citation")
	private String citation;
	
	@Column(name="volume")
	private String volume;
	
	@Column(name="year")
	private String year;
	
	@Column(name="pages")
	private String pages;
	
	@Column(name="title")
	private String title;
	private Xrefs xrefs;
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="incrementor")
	private int id;
	
	@Column(name="fkReference")
	private int fkReferenceId;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkReferenceId() {
		return fkReferenceId;
	}

	public void setFkProteinEntry(int fkReferenceId) {
		this.fkReferenceId = fkReferenceId;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	public String getCitation() {
		return citation;
	}

	public void setCitation(String citation) {
		this.citation = citation;
	}
	
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

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
