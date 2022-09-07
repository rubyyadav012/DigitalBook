package com.digitalBook.bookService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitalBook.entity.Author;
import com.digitalBook.entity.Book;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.AuthorRepo;
import com.digitalBook.repository.BookRepository;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Service
public class BookService {



    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepo authorRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }


    public Optional<Book> getBookById(Integer bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookRepo.findById(bookId);
    }


    public Book createBook(Integer authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorRepo.findById(authorId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
        Author author = byId.get();

        //tie Author to Book
        //book.setAuthor(author);
        
        Book book1 = bookRepo.save(book);
        
        //tie Book to Author
        books.add(book1);
        //author1.setBooks(books);

        return book1;

    }

    public Book updateBook(Integer bookId, Book bookRequest) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        Optional<Book> book = bookRepo.findById(bookId);

        if (!book.isPresent()) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        Book book1 = book.get();
     
        /*book1.setTitle(bookRequest.getTitle());
        book1.setImage(bookRequest.getImage());
        
        book1.setCategory(bookRequest.getCategory());
        book1.setPrice(bookRequest.getPrice());
        book1.setPublisher(bookRequest.getPublisher());
        book1.setPublisher_Date(bookRequest.getPublisher_Date());
        book1.setContents(bookRequest.getContents());
        book1.setStatus(bookRequest.getStatus());*/
        

        return bookRepo.save(book1);
    }

    public ResponseEntity<Object> deleteBookById(int bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        bookRepo.deleteById(bookId);

        return ResponseEntity.ok().build();

    }
}




