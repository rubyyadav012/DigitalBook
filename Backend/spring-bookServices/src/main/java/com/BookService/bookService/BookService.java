package com.BookService.bookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookService.Entity.Book;
import com.BookService.bookRepo.BookRepository;

@Service

public class BookService {
	
	
	
	@Autowired
	BookRepository bookRepository;
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

}


