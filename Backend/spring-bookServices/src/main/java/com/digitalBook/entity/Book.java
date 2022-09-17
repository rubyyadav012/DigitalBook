package com.digitalBook.entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String image;
	
	@NotBlank(message="title can't be blank")
	private String title;
	
	private Catagory catagory;
	
	@NotNull(message="price can not be null")
	private BigDecimal price;
	
	@NotBlank(message="please mentioned publisher name")
	private String publisher;
	
	
	private Date publisherDate;
	
	@NotBlank(message="please address contents")
	private String contents;

	private boolean status;
	
	@NotBlank(message="please mentioned author")
	private String author;
	
}

