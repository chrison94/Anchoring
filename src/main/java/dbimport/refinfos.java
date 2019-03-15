package dbimport;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

@Entity(name = "refinfos")
public class refinfos {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "CUST_GEN")
	private int id;

	@Column(name = "citation")
	@ColumnDefault("null")
	private String citation;

	@Column(name = "volume")
	@ColumnDefault("null")
	private String volume;

	@Column(name = "year")
	@ColumnDefault("null")
	private String year;

	@Column(name = "pages")
	@ColumnDefault("null")
	private String pages;

	@Column(name = "title")
	@ColumnDefault("null")
	private String title;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRefinfoId", nullable = true)
	private Collection<xrefs> xrefs;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkRefinfoId", nullable = true)
	private Collection<authors> authors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthors(List<authors> authors) {
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

	public void setXrefs(List<xrefs> xrefs) {
		this.xrefs = xrefs;
	}

	public refinfos(String citation, String volume, String year, String pages, String title) {
		super();
//		this.authors = authors;
		this.citation = citation;
		this.volume = volume;
		this.year = year;
		this.pages = pages;
		this.title = title;
	}

	public refinfos() {
		super();
	}

}
