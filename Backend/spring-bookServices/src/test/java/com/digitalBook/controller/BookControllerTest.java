package com.digitalBook.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import com.digitalBook.bookService.BookService;
import com.digitalBook.entity.Book;
import com.digitalBook.entity.Catagory;
import com.digitalBook.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
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

	@Test
	public void getBook() throws Exception {
		mockmvc.perform(get("/digitalbooks/books/search/allBook")).andExpect(status().isOk());

	}

	@Test
	public void getById() throws Exception {
		mockmvc.perform(get("/digitalbooks/book/{bookId}", 1)).andExpect(status().isOk());
	}

	@Test
	public void updateBook() throws ResourceNotFoundException {

		Book book1 = new Book();

		when(bookService.updateBook(1, book1)).thenReturn(book1);
		assertNotNull(bookService.updateBook(1, book1));
		}
	
	/*@Test
	public void updateBookTest() throws Exception {
       mockmvc.perform(get("/digitalbooks/{authorId}/books",1)).andExpect(status().isOk());
}*/
}