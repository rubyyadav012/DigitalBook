package com.digitalBook.Entity;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	private String image;
	

	private String title;
	
	
	private String catagory;
	
    //@NotNull(message="it must be some value")
	private Long price;
    
    //@NotBlank(message="Publisher name must be mentioned")
    //@Column(nullable=false)
    private String publisher;
    
    
   //@NotBlank(message="please mention publisher date")
	private Date publisher_Date;
    
    
    //@NotBlank(message="contents must be mention")
	private String contents;
    
    
	private char status;
	
	/*@Column(nullable=false)
	private int author_id;*/
	
	@OneToOne(cascade=CascadeType.ALL)
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

	public void setId(int book) {
		this.id = book;
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

	public Date getPublisher_Date() {
		return publisher_Date;
	}

	public void setPublisher_Date(Date date) {
		this.publisher_Date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public char isStatus() {
		return status;
	}


	public char getStatus() {
		return status;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	

}

