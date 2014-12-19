package com.andrew.book.citator.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andrew.book.citator.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("FROM User where username = ?1")
    User getUserByName(String username);

    @Query("FROM User where email = ?1")
    User getUserByEmail(String email);
    
    
}
