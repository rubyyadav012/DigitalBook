package com.digitalBook.controller;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.digitalBook.bookService.BookService;
import com.digitalBook.entity.Book;
import com.digitalBook.entity.Catagory;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {
	

	@Mock
	BookService bookService;
	
    @InjectMocks
    BookController bookController;
    
	@Test
	void testCreateBook() {
		
	
		
		Book book=new Book();
	
		book.setId(1);
		book.setCategory(Catagory.JAVA);
		book.setAuthor("ruby");
		book.setImage(" ");
		book.setContents("just for fun");
		book.setPrice(new BigDecimal(500));
		book.setPublisher("the moon");
		//book.setPublisherDate(new Date(9/8/2022));
		book.setStatus(true);
		
		
	new ResponseEntity<>(book,HttpStatus.CREATED);
		
		when(bookService.createBook(1,book)).thenReturn(book);
		
		assertEquals(book, bookController.createBook(1, book).getBody());
		
	}
	
	@Test
	void testUpdateBook() {
		
	
		
		Book book=new Book();
	
		book.setId(1);
		book.setCategory(Catagory.JAVA);
		book.setAuthor("ruby");
		book.setImage(" ");
		book.setContents("just for fun");
		book.setPrice(new BigDecimal(500));
		book.setPublisher("the moon");
		book.setPublisherDate(new Date(9/8/2022));
		book.setStatus(true);
		
		
	
		
		when(bookService.updateBook(1,book)).thenReturn(book);
		System.out.println(bookController.updateBook(1,book.getId(),book).getBody());
		assertTrue(bookController.updateBook(1,book.getId(),book).getBody() instanceof Book);
		
	}
	
	
	
}
