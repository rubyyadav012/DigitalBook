package com.digitalBook.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalBook.Entity.Book;
import com.digitalBook.bookRepo.BookRepository;
import com.digitalBook.bookService.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/author")

public class BookController<updatedBook>  {
	
	@Autowired
	
	BookService bookservice;
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getBook() {
		return ResponseEntity.ok(this.bookservice.getBook());
	}
	
	
	//to get single book 
	
	@GetMapping("/authorId")
	public ResponseEntity<Book> getSingleBook(@Valid@PathVariable int authorId,@RequestBody Book book){
		
		
		return ResponseEntity.ok(this.bookservice.getBookById(authorId));
		
		
		
	}
	
	@PostMapping("/{authorId}")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book,@PathVariable int authorId)   {
	
	
		Book book1=this.bookservice.createBook(book,authorId);
	
		return new ResponseEntity<Book>(book1,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/authorId/{authod_Id}/book/{bookId}")
	
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book bookId,@PathVariable Book book) {
		Book updatedBook1=this.bookservice.saveorUpdate(bookId,book);
		return  ResponseEntity.ok(updatedBook1);
	
		
		

	}

	
	/*@DeleteMapping("/id")
	public Book deleteBook(@PathVariable int id) {
		Book book=bookservice.
		
		
	}*/

}
