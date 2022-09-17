package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {

}
