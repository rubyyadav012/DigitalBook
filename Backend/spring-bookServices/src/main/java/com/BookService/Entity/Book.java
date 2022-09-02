package com.BookService.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String image;
	

	private String title;
	
	
	private String catagory;
	

	private Long price;
	private String publisher;
	private String publisher_Date;
	private String contents;
	private boolean status;
	
	

	@OneToOne(cascade=CascadeType.ALL)
	@NotBlank(message="Author name must be mentioned")
	private Author author;

	
    @Override
	public String toString() {
		return "Book [id=" + id + ", image=" + image + ", title=" + title + ", catagory=" + catagory + ", price="
				+ price + ", publisher=" + publisher + ", publisher_Date=" + publisher_Date + ", contents=" + contents
				+ ", status=" + status + ", author=" + author + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher_Date() {
		return publisher_Date;
	}

	public void setPublisher_Date(String publisher_Date) {
		this.publisher_Date = publisher_Date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}

