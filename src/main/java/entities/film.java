package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import hibernate.LastUpdateListener;

@Entity
@EntityListeners( LastUpdateListener.class )
@Table(name = "film",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })

public class film {
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "titleId")	 
	String titleId;
	
	@Column(name = "ordering")
	int ordering;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "region")
	String region;

	@Column(name = "language")
	String language;
	
	@Column(name = "types")	
	String types;

	@Column(name = "attributes")
	String attributes;

	@Column(name = "isOriginalTitle")
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

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getTitleId() {
	return titleId;
}
public void setTitleId(String titleId) {
	this.titleId = titleId;
}

public int getOrdering() {
	return ordering;
}
public void setOrdering(int ordering) {
	this.ordering = ordering;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}

public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}

public String getTypes() {
	return types;
}
public void setTypes(String types) {
	this.types = types;
}

public String getAttributes() {
	return attributes;
}
public void setAttributes(String attributes) {
	this.attributes = attributes;
}

public boolean getIsOriginalTitle() {
	return isOriginalTitle;
}
public void setIsOriginalTitle(boolean isOriginalTitle) {
	this.isOriginalTitle = isOriginalTitle;
}

}