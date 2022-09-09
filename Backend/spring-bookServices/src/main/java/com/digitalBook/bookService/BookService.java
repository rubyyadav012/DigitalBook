package com.digitalBook.bookService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitalBook.entity.User;
import com.digitalBook.entity.Book;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.UserRepo;
import com.digitalBook.repository.BookRepository;

@Service
public class BookService {



    @Autowired
    BookRepository bookRepo;

    @Autowired
    UserRepo userRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    /*public Set<Book> searchBook(String category, String author, BigDecimal price, String publisher) {
		Set<Book> bookList = new HashSet<>();;
		
		if (category != null) {
			bookList.addAll(bookRepo.searchBookByCategory(category));
		}
		if (author != null) {
			bookList.addAll(bookRepo.searchBookByAuthor(author));

		}
		if (price != null) {
			bookList.addAll(bookRepo.searchBookByPrice(price));
		}
		if (publisher != null) {
			bookList.addAll(bookRepo.searchBookByPublisher(publisher));

		}
		return bookList;
		
		
	}*/
    



    public Optional<Book> getBookById(Integer bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookRepo.findById(bookId);
    }
    


    public Book createBook(Integer userId, Book book) {
        Set<Book> books = new HashSet<>();
        User user1 = new User();
        
        	 Optional<User> byId = userRepo.findById(userId);
        	 if (!byId.isPresent()) {
                 throw new ResourceNotFoundException("Author with id " + userId + " does not exist");
             }
        
        Book response= bookRepo.save(book);
      
        
 
		return  response;

       
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
     
        book1.setTitle(bookRequest.getTitle());
        book1.setImage(bookRequest.getImage());
        book1.setCategory(bookRequest.getCategory());
        book1.setPrice(bookRequest.getPrice());
        book1.setPublisher(bookRequest.getPublisher());
        book1.setPublisherDate(bookRequest.getPublisherDate());
        book1.setContents(bookRequest.getContents());
        book1.setStatus(bookRequest.isStatus());
        

        return bookRepo.save(book1);
    }

    public ResponseEntity<Object> deleteBookById(int bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        bookRepo.deleteById(bookId);

        return ResponseEntity.ok().build();

    }

	/*public Optional<Book> getById(Integer bookId) {
		// TODO Auto-generated method stub
		return bookRepo.findById(bookId);
	}*/


	
}




