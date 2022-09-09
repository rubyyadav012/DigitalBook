package com.digitalBook.repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.digitalBook.entity.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query(value = "select * from book b where b.category=:category", nativeQuery = true)
	Set<Book> searchBookByCategory(@Param("category") String category);

	@Query(value = "select * from book b where b.author=:author", nativeQuery = true)
	Set<Book> searchBookByAuthor(@Param("author") String author);

	@Query(value = "select * from book b where b.price=:price", nativeQuery = true)
	Set<Book> searchBookByPrice(@Param("price") BigDecimal price);

	@Query(value = "select * from book b where  b.publisher=:publisher", nativeQuery = true)
	Set<Book> searchBookByPublisher(@Param("publisher") String publisher);

}
