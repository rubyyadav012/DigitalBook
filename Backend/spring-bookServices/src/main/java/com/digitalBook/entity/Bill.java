package com.digitalBook.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Bill implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer paymentId;
	
	@ManyToOne(targetEntity=Book.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="book_id",referencedColumnName="id")
	private Book book;

	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="paymentMethod")
	private String paymentMethod;
	
	private PaymentStatus paymentStatus;
	
	@Column(name="totalAmount")
	private Integer totalAmount;
	
	@Column(name="paymentDate")
	private Date paymentDate;
	
	//@Column(name="bill_id")
	//private int billId;
	

	@Transient
	private boolean refund;
	
	@Column(name="cardNo")
	private String cardNo;
	
}