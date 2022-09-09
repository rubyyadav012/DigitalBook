package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
  

}
