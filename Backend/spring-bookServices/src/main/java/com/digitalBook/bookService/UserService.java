package com.digitalBook.bookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitalBook.entity.User;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.UserRepo;


	@Service
	public class UserService {
	    @Autowired
	    UserRepo authorRepo;

	    public List<User> getAuthors() {
	        return authorRepo.findAll();
	    }


	    public Optional<User> getAuthorById(Integer authorId) {
	        if (!authorRepo.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
	        return authorRepo.findById(authorId);
	    }


	    public User createAuthor(User author) {
	        return authorRepo.save(author);

	    }

	    public User updateAuthorById(Integer authorId, User authorRequest) {
	        if (!authorRepo.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
	        Optional<User> author = authorRepo.findById(authorId);

	        if (!author.isPresent()) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }

	        User author1 = author.get();
	       // author1.setFirstName(authorRequest.getFirstName());
	       // author1.setLastName(authorRequest.getLastName());
	        return authorRepo.save(author1);

	    }

	    public ResponseEntity<Object> deleteAuthorById(Integer authorId) {
	        if (!authorRepo.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }

	        authorRepo.deleteById(authorId);

	        return ResponseEntity.ok().build();

	    }


		public boolean existsByusername(Object username) {
			// TODO Auto-generated method stub
			return false;
		}


	}