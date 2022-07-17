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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Book Persistence Object Entity
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Book Entity Representation")
public class Book {
	/** Primary key */
	@Id
	@EqualsAndHashCode.Include
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

	@SuppressWarnings("nls")
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", unitCost=" + unitCost + ", isbn=" + isbn + ", publicationDate=" + publicationDate
				+ ", numberOfPages=" + numberOfPages + ", imageUrl=" + imageUrl + ", language=" + language + "]";
	}

}
