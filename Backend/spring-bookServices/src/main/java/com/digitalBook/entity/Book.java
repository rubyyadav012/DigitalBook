package com.digitalBook.entity;
import javax.persistence.GeneratedValue;

import java.util.Date;
import java.util.Enumeration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
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
	private Integer id;
	
	
	private String image;
	

	private String title;
	
	
	//private Enumeration catagory;
	
	private String catagory;
	
    @NotNull(message="it must be some value")
	  private double price;
    
    @NotBlank(message="Publisher name must be mentioned")
    @Column(nullable=false)
    private String publisher;
    
    
   //@NotBlank(message="please mention publisher date")
	//private Date publisher_Date;
    
    private String publisher_Date;
    
    
    @NotBlank(message="contents must be mention")
	private String contents;
    
    
	private boolean status;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", nullable = false)
	 private Author author;
	
}

