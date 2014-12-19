package com.andrew.book.citator.service;

import java.util.LinkedList;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.User;

public interface BookService {

    Book getBook(String bookId);

    void saveBook(Book book);

    LinkedList<Book> getBookList(User user);

}
