package com.andrew.book.citator.service;

import java.util.LinkedList;

import com.andrew.book.citator.entity.Quote;

public interface QuoteService {
    
    void saveQuote(Quote quote);
    
    LinkedList<Quote> getBookQuotes(String idbook);

}
