package com.digitalBook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalBook.bookService.BookService;
import com.digitalBook.entity.Book;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.BookRepository;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/digitalbooks/")
public class BookController {

	@Autowired
	BookService bookService;

//	@Autowired
//	BookRepository bookRepository;


	@PostMapping("author/{authorId}/books")
	public ResponseEntity<?> createBook(@Valid @PathVariable("authorId") Integer id, @RequestBody Book book) {

		Book createdBook = bookService.createBook(id,book);

		return new ResponseEntity<>(createdBook,HttpStatus.CREATED);
	}

	@PutMapping("author/{authorId}/books")
	public ResponseEntity<?> updateBook(@Valid@PathVariable("authorId") int authorId, @PathVariable("authorId") Integer bookId,
			@RequestBody Book book) throws ResourceNotFoundException {

		
		Book updatedBook = bookService.updateBook(bookId,book);
		/*if (updateBook == null) {
			return new ResponseEntity<>("Book does not exist", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updateBook, HttpStatus.FOUND);*/
		
		return new ResponseEntity<>(updatedBook,HttpStatus.FOUND);

	}

	/*@GetMapping("/books/search")
	@ResponseBody
	public ResponseEntity<?> searchBook(@RequestParam(required = false) String category,
			@RequestParam(required = false) String author, @RequestParam(required = false) String price,
			@RequestParam(required = false) String publisher) {
		//Set<Book> bookList=bookService.getAllBook(category, author, price, publisher);
		List<Book> bookList=bookService.getAllBooks();
		if(bookList!=null) {
			return new ResponseEntity<>(bookList, HttpStatus.FOUND);
			
		}
		return new ResponseEntity<>("No Books Found", HttpStatus.NOT_FOUND);

	}*/

}
