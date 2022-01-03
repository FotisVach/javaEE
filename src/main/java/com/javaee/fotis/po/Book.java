package com.javaee.fotis.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.javaee.fotis.enums.Language;

/**
 * Book Persistence Object Entity
 */
@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 200)
	private String title;
	
	@Column(length = 1000)
	private String description;
	
	@Column(name = "unit_cost")
	private Float unitCost;
	
	private String isbn;
	
	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	
	private Integer numberOfPages;
	
	private String imageUrl;
	
	private Language language;

	/**
	 * Gets the id.
	 *
	 * @return Returns the id
	 */
	Long getId() {
		return id;
	}

	/**
	 * Assigns a new value to the id.
	 *
	 * @param id the id to set
	 */
	void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return Returns the title
	 */
	String getTitle() {
		return title;
	}

	/**
	 * Assigns a new value to the title.
	 *
	 * @param title the title to set
	 */
	void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return Returns the description
	 */
	String getDescription() {
		return description;
	}

	/**
	 * Assigns a new value to the description.
	 *
	 * @param description the description to set
	 */
	void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the unitCost.
	 *
	 * @return Returns the unitCost
	 */
	Float getUnitCost() {
		return unitCost;
	}

	/**
	 * Assigns a new value to the unitCost.
	 *
	 * @param unitCost the unitCost to set
	 */
	void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * Gets the isbn.
	 *
	 * @return Returns the isbn
	 */
	String getIsbn() {
		return isbn;
	}

	/**
	 * Assigns a new value to the isbn.
	 *
	 * @param isbn the isbn to set
	 */
	void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the publicationDate.
	 *
	 * @return Returns the publicationDate
	 */
	Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Assigns a new value to the publicationDate.
	 *
	 * @param publicationDate the publicationDate to set
	 */
	void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets the numberOfPages.
	 *
	 * @return Returns the numberOfPages
	 */
	Integer getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * Assigns a new value to the numberOfPages.
	 *
	 * @param numberOfPages the numberOfPages to set
	 */
	void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * Gets the imageUrl.
	 *
	 * @return Returns the imageUrl
	 */
	String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Assigns a new value to the imageUrl.
	 *
	 * @param imageUrl the imageUrl to set
	 */
	void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Gets the language.
	 *
	 * @return Returns the language
	 */
	Language getLanguage() {
		return language;
	}

	/**
	 * Assigns a new value to the language.
	 *
	 * @param language the language to set
	 */
	void setLanguage(Language language) {
		this.language = language;
	}

	@SuppressWarnings("nls")
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost
				+ ", isbn=" + isbn + ", publicationDate=" + publicationDate + ", numberOfPages=" + numberOfPages
				+ ", imageUrl=" + imageUrl + ", language=" + language + "]";
	}
	
	
	
}
