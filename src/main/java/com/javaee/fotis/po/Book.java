package com.javaee.fotis.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.javaee.fotis.enums.Language;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Book Persistence Object Entity
 */
@Entity
@Schema(description = "Book Entity Representation")
public class Book {
	/** Primary key */
	@Id
	@GeneratedValue(generator = "book_seq")
	@Schema(description = "Identifier")
	private Long id;
	/** Book'stitle */
	@Column(length = 200)
	@NotNull
	@Size(min = 1, max = 200)
	@Schema(description = "Title of the book")
	private String title;
	/** Book's author */
	@Column(length = 50)
	@NotNull
	@Size(min = 1, max = 50)
	@Schema(description = "Author of the book")
	private String author;
	/** Book's decription */
	@Column(length = 1000)
	@Size(min = 1, max = 1000)
	@Schema(description = "Description of the book")
	private String description;
	/** Book's cost */
	@Column(name = "unit_cost")
	@Schema(description = "Cost of the book")
	private Float unitCost;
	/** Book's isbn */
	@NotNull
	@Size(min = 1, max = 50)
	private String isbn;
	/** Book's publication date */
	@Column(name = "publication_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Past
	private Date publicationDate;
	/** Book's number of pages */
	private Integer numberOfPages;
	/** Book's image url */
	private String imageUrl;
	/** Book's language */
	private Language language;

	/**
	 * Gets the id.
	 *
	 * @return Returns the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Assigns a new value to the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return Returns the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Assigns a new value to the title.
	 *
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the author.
	 *
	 * @return Returns the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Assigns a new value to the author.
	 *
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the description.
	 *
	 * @return Returns the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Assigns a new value to the description.
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the unitCost.
	 *
	 * @return Returns the unitCost
	 */
	public Float getUnitCost() {
		return unitCost;
	}

	/**
	 * Assigns a new value to the unitCost.
	 *
	 * @param unitCost
	 *            the unitCost to set
	 */
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * Gets the isbn.
	 *
	 * @return Returns the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Assigns a new value to the isbn.
	 *
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the publicationDate.
	 *
	 * @return Returns the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Assigns a new value to the publicationDate.
	 *
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets the numberOfPages.
	 *
	 * @return Returns the numberOfPages
	 */
	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * Assigns a new value to the numberOfPages.
	 *
	 * @param numberOfPages
	 *            the numberOfPages to set
	 */
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * Gets the imageUrl.
	 *
	 * @return Returns the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Assigns a new value to the imageUrl.
	 *
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Gets the language.
	 *
	 * @return Returns the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Assigns a new value to the language.
	 *
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	@SuppressWarnings("nls")
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", unitCost=" + unitCost + ", isbn=" + isbn + ", publicationDate=" + publicationDate
				+ ", numberOfPages=" + numberOfPages + ", imageUrl=" + imageUrl + ", language=" + language + "]";
	}

}
