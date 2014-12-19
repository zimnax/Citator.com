package com.andrew.book.citator.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.Quote;
import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.service.BookService;
import com.andrew.book.citator.service.QuoteService;
import com.andrew.book.citator.service.UserService;

@Controller
@RequestMapping("/book")
public class BookController {

	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@Autowired
	QuoteService quoteService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAuthorizationView() {
		return "addNewBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(@RequestParam String bookname, @RequestParam String author, @RequestParam int publishYear,
			ModelMap modelMap, HttpSession session) {
		LOGGER.info("Start add new book");

		User sessionUser = (User) session.getAttribute("sessionUser");

		Book book = new Book();

		book.setBookname(bookname);
		book.setAuthor(author);
		book.setPublishYear(publishYear);
		book.setUser(sessionUser);

		bookService.saveBook(book);

		LOGGER.info("Book had been added successfully");

		return "redirect:/" + sessionUser.getUsername();
	}

	@RequestMapping(value = "/{idBook}", method = RequestMethod.GET)
	public String viewBook(HttpServletRequest request, ModelMap modelMap) {

		String idBook = StringUtils.substringAfterLast(request.getServletPath(), "/");
		System.out.println("idBook: " + idBook);

		Book bookToView = bookService.getBook(idBook);
		LinkedList<Quote> bookQuotes = quoteService.getBookQuotes(idBook);

		modelMap.addAttribute("currentBook", bookToView);
		modelMap.addAttribute("bookQuotesList", bookQuotes);

		return "bookView";
	}

}
