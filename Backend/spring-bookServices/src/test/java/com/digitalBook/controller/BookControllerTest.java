package com.digitalBook.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalBook.bookService.BookService;
import com.digitalBook.entity.Book;
import com.digitalBook.entity.Catagory;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {
	
	@Autowired
	private MockMvc mockmvc;

	@Mock
	BookService bookService;

	@InjectMocks
	BookController bookController;

	@Test
	void testCreateBook() {

		Book book = new Book();

		book.setId(1);
		book.setCatagory(Catagory.JAVA);
		book.setAuthor("ruby");
		book.setImage(" ");
		book.setContents("just for fun");
		book.setPrice(new BigDecimal(500));
		book.setPublisher("the moon");
		book.setPublisherDate(new Date(9 / 8 / 2022));
		book.setStatus(true);

		new ResponseEntity<>(book, HttpStatus.CREATED);

		when(bookService.createBook(1, book)).thenReturn(book);

		assertEquals(book, bookController.createBook(1, book).getBody());

	}
	  
	/* @Test
	    public void getBook() throws Exception {
		mockmvc.perform(get("/books/search/allBook")).andExpect(status().isOk());
		
		
	}
	
		   
		   
		   @Test
		    public void getById() throws Exception {
			mockmvc.perform(get("/book/{bookId}").param("bookId", "1")).andExpect(status().isOk());
			
			mockmvc.perform(get("/book/{bookId}").param("bookId", null)).andExpect(status().isBadRequest());
		}*/
		   
	   }


