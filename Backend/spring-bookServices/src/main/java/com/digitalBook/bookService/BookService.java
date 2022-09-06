package com.digitalBook.bookService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalBook.Entity.Book;
import com.digitalBook.Exception.ResourceNotFoundException;
import com.digitalBook.bookRepo.BookRepository;

@Service

public class BookService {
	
	
	
	@Autowired
	BookRepository bookRepository;
	
	/*public Book save(Book book) {
		return bookRepository.save(book);
	}*/

	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public Book getBookById(Integer bookId) {
	  Book book=this.bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book","Id",bookId));
		return book;
	}

	public Book createBook(Book book,int authorId) {
		
		return bookRepository.save(book);
	}

	public Book saveorUpdate(@Valid Book bookId, Book book) {
		return bookId;
		
	}


}


