package com.andrew.book.citator.service.impl;

import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.repositories.BookRepository;
import com.andrew.book.citator.service.BookService;

@Component
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

    @Autowired
    BookRepository bookRepository;

    public void saveBook(Book book) {
        LOGGER.info("Start to save new book in repository");
        bookRepository.save(book);
    }

    public LinkedList<Book> getBookList(User user) {
        LOGGER.info("Start to grap all Books of current user with id: " + user.getIdUser());
        return bookRepository.getUserBooks(user);
    }

    public Book getBook(String bookId) {
        LOGGER.info("Start to find book by id: " + bookId);
        return bookRepository.findOne(Long.parseLong(bookId));
    }

}
