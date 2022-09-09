package com.digitalBook.controller;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.bookService.BookService;
import com.digitalBook.entity.Book;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.BookRepository;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/digitalbooks/")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BookRepository bookRepository;


	@PostMapping("author/{authorId}/books")
	public ResponseEntity<?> createBook(@Valid @PathVariable("authorId") Integer id, @RequestBody Book book) {

		Book createdBook = bookService.createBook(id,book);

		return new ResponseEntity<>(createdBook,HttpStatus.CREATED);
	}

	@PutMapping("author/{authorId}/books")
	public ResponseEntity<?> updateBook(@Valid@PathVariable("authorId") int authorId, @PathVariable("bookId") Integer bookId,
			@RequestBody Book book) throws ResourceNotFoundException {

		Book updatedBook = bookService.updateBook(bookId,book);
		
		return new ResponseEntity<>(updatedBook,HttpStatus.FOUND);

	}

	@GetMapping("/books/search/allBook")
	public List<Book> getBook(){
		return bookService.getAllBooks();
	}

	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getById(@PathVariable Integer bookId) {
		Optional<Book> book=bookService.getBookById(bookId);
		if(book.isPresent()) {
			return new ResponseEntity<>(book.get(),HttpStatus.OK);
		}
			else {
				throw new ResourceNotFoundException();
			}
		}
	}
	


