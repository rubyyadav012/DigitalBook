package com.digitalBook.bookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitalBook.entity.Author;
import com.digitalBook.exception.ResourceNotFoundException;
import com.digitalBook.repository.AuthorRepo;


	@Service
	public class AuthorService {
	    @Autowired
	    AuthorRepo authorRepo;

	    public List<Author> getAuthors() {
	        return authorRepo.findAll();
	    }


	    public Optional<Author> getAuthorById(Integer authorId) {
	        if (!authorRepo.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
	        return authorRepo.findById(authorId);
	    }


	    public Author createAuthor(Author author) {
	        return authorRepo.save(author);

	    }

	    public Author updateAuthorById(Integer authorId, Author authorRequest) {
	        if (!authorRepo.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
	        Optional<Author> author = authorRepo.findById(authorId);

	        if (!author.isPresent()) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }

	        Author author1 = author.get();
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


	}