package dbimport;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="refinfos")
public class RefInfo {
	@Id @Column(name="id") 	
	@GeneratedValue(generator="CUST_GEN")
	private int id;
	
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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="xrefs",joinColumns=@JoinColumn(name="fkRefinfoId" , insertable=false, updatable=false , nullable = true))
	private Collection<Xref> xrefs;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="authors",joinColumns=@JoinColumn(name="fkRefinfoId" , insertable=false, updatable=false , nullable = true))
	private Collection<Author> authors;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
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
	
	public Collection<Xref> getXrefs() {
		return xrefs;
	}

	public void setXrefs(List<Xref> xrefs) {
		this.xrefs = xrefs;
	}

	public RefInfo( String citation, String volume, String year, String pages, String title) {
		super();
//		this.authors = authors;
		this.citation = citation;
		this.volume = volume;
		this.year = year;
		this.pages = pages;
		this.title = title;
	}

	public RefInfo() {
		super();
	}


}
