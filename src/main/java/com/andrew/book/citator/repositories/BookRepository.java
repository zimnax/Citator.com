package com.andrew.book.citator.repositories;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.User;

public interface BookRepository extends CrudRepository<Book, Long> {
    
    
    @Query("FROM Book where user = ? ORDER BY bookname ASC" )
    LinkedList<Book> getUserBooks (User user);

}
