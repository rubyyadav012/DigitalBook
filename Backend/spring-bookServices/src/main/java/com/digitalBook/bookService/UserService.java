package com.digitalBook.bookService;
import org.springframework.http.ResponseEntity;
import com.digitalBook.entity.User1;


public interface UserService {

	public ResponseEntity<String> signUp(User1 requestMap);

}
