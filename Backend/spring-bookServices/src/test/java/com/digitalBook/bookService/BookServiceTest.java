package com.digitalBook.bookService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.digitalBook.entity.Book;
import com.digitalBook.entity.Catagory;
import com.digitalBook.repository.BookRepository;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	
	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	BookService bookService;
	
	
	@Test
	void testgetBook() {
		Book book=new Book();
		book.setId(1);
		book.setCategory(Catagory.JAVA);
		book.setAuthor("ruby");
		book.setImage(" ");
		book.setContents("just for fun");
		book.setPrice(new BigDecimal(500));
		book.setPublisher("the moon");
		book.setPublisherDate(new Date(9/8/2022));
		book.setStatus(true);
		List<Book> allBooks=new ArrayList<>();
		allBooks.add(book);
		when(bookRepository.findAll()).thenReturn(allBooks);
		assertEquals(1, bookService.getAllBooks().size());
	}

	
	@Test
	void testgetBookById() {
		Book book=new Book();
		book.setId(1);
		book.setCategory(Catagory.JAVA);
		book.setAuthor("ruby");
		book.setImage(" ");
		book.setContents("just for fun");
		book.setPrice(new BigDecimal(500));
		book.setPublisher("the moon");
		book.setPublisherDate(new Date(9/8/2022));
		book.setStatus(true);
		
		Optional.of(book);
		
		List<Book> allBooks=new ArrayList<>();
		allBooks.add(book);
		when(bookRepository.findAll()).thenReturn(allBooks);
		assertEquals(1, bookService.getAllBooks().size());
	}

	
}