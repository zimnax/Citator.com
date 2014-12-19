package com.andrew.book.citator.service.impl;

import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrew.book.citator.entity.Quote;
import com.andrew.book.citator.repositories.QuoteRepository;
import com.andrew.book.citator.service.QuoteService;

@Component
public class QuoteServiceImpl implements QuoteService {
    private static final Logger LOGGER = Logger.getLogger(QuoteServiceImpl.class);

    @Autowired
    QuoteRepository quoteRepository;

    public void saveQuote(Quote quote) {
        LOGGER.info("Strat to save new quote in repository");
        quoteRepository.save(quote);
    }

    public LinkedList<Quote> getBookQuotes(String idbook) {
        return quoteRepository.getBookQuotes(Integer.parseInt(idbook));
    }


}
