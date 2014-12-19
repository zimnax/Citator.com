package com.andrew.book.citator.repositories;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Long> {
    
    
    @Query("FROM Quote where idbook = ? ORDER BY id ASC" )
    LinkedList<Quote> getBookQuotes (int idbook);

}
