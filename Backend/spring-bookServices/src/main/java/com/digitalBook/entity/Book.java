package com.digitalBook.entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;
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
	private Integer Id;
	
	private String image;
	
	@NotBlank(message="title can't be blank")
	private String title;
	
	private Catagory category;
	private BigDecimal price;
	
	private String publisher;
	
	private Date publisherDate;
	
	private String contents;
	
	@ColumnDefault("0")
	private boolean status;
	
	
	private String author;
	
}

