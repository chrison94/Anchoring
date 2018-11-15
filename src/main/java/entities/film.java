package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "film",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })

public class film {
	int id;
	String titleId;
	int ordering;
	String title;
	String region;
	String language;
	String types;
	String attributes;
	boolean isOriginalTitle; 

	public film() {
		
	}

public film(int id,String titleId, int ordering, String title, String region, String language, String types,
		String attributes, boolean isOriginalTitle) {
	this.id = id;
	this.titleId = titleId;
	this.ordering = ordering;
	this.title = title;
	this.region = region;
	this.language = language;
	this.types = types;
	this.attributes = attributes;
	this.isOriginalTitle = isOriginalTitle;
	}

@Id
@Column(name = "id")
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

@Column(name = "titleId")
public String getTitleId() {
	return titleId;
}
public void setTitleId(String titleId) {
	this.titleId = titleId;
}

@Column(name = "ordering")
public int getOrdering() {
	return ordering;
}
public void setOrdering(int ordering) {
	this.ordering = ordering;
}

@Column(name = "title")
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

@Column(name = "region")
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}

@Column(name = "language")
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}

@Column(name = "types")
public String getTypes() {
	return types;
}
public void setTypes(String types) {
	this.types = types;
}

@Column(name = "attributes")
public String getAttributes() {
	return attributes;
}
public void setAttributes(String attributes) {
	this.attributes = attributes;
}

@Column(name = "isOriginalTitle")
public boolean getIsOriginalTitle() {
	return isOriginalTitle;
}
public void setIsOriginalTitle(boolean isOriginalTitle) {
	this.isOriginalTitle = isOriginalTitle;
}

}