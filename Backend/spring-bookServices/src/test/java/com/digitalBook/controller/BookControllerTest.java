package com.digitalBook.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.digitalBook.bookService.BookService;
import com.digitalBook.controller.BookController;
import com.digitalBook.entity.Book;

public class BookControllerTest {

	
	@Mock
	BookService bookService;

	@InjectMocks
	BookController controller;

	@Test
	void createBook() {
	    Book book = new Book();
		//book.setAuthor(1);
		
		//when(service.save(user)).thenReturn(user);
		//when(bookService.save(book)).thenReturn(book);
		
	      //Integer saveUser = controller.saveUser(book);
		
		 //assertEquals(1, saveUser);
	}
	
}

