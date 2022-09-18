package com.digitalBook.bookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    
    
    public Optional<Book> getBookById(Integer bookId) throws ResourceNotFoundException {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException();
        }
        return bookRepo.findById(bookId);
    }
    


    public Book createBook(Integer userId, Book book) {
        Book response= bookRepo.save(book);
		return  response;     
    }

    public Book updateBook(Integer bookId, Book bookRequest) throws ResourceNotFoundException {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException();
        }
        Optional<Book> book = bookRepo.findById(bookId);

        if (!book.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Book book1 = book.get();
     
        book1.setTitle(bookRequest.getTitle());
        book1.setImage(bookRequest.getImage());
        book1.setCatagory(bookRequest.getCatagory());
        book1.setPrice(bookRequest.getPrice());
        book1.setPublisher(bookRequest.getPublisher());
        book1.setPublisherDate(bookRequest.getPublisherDate());
        book1.setContents(bookRequest.getContents());
        book1.setStatus(bookRequest.isStatus());
        

        return bookRepo.save(book1);
    }

    public ResponseEntity<Object> deleteBookById(int bookId) throws ResourceNotFoundException {
        if (!bookRepo.existsById(bookId)) {
            throw new ResourceNotFoundException();
        }

        bookRepo.deleteById(bookId);

        return ResponseEntity.ok().build();

    }
	
}




