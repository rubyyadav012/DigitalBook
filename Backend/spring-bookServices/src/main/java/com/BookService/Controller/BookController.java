package com.BookService.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookService.Entity.Book;
import com.BookService.bookRepo.BookRepository;
import com.BookService.bookService.BookService;


@RestController
@RequestMapping("/book")

public class BookController {
	
	@Autowired
	
	BookService bookservice;
	
	@GetMapping
	Iterable<Book> getBook() {
		return bookservice.getBook();
	}
	
	@PostMapping
	Integer savebook1(@Valid @RequestBody Book book)   {
		bookservice.save(book);//mock
		System.out.println("second");
		return book.getId();
	}
	
	@PutMapping("/update")
	
	public void updateBookRecord(@RequestBody Book book) {
		 bookservice.save(book);
	}

	
	/*@DeleteMapping("/id")
	public Book deleteBook(@PathVariable int id) {
		Book book=bookservice.
		
		
	}*/

}
