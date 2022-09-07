package com.digitalBook.entity;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
	private String title;
	private String category;
	private BigDecimal price;
	
	private String publisher;
	
	private Date publisherDate;
	
	private String contents;
	
	@ColumnDefault("0")
	private boolean status;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false,updatable=false,insertable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)*/
	
	private String author;
	
}

