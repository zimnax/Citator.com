package com.andrew.book.citator.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.Quote;
import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.service.BookService;
import com.andrew.book.citator.service.QuoteService;

@Controller
@RequestMapping("/quote")
public class QuoteController {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@Autowired
	QuoteService quoteService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String addQuote(@RequestParam String quote, @RequestParam String currentBookId, ModelMap modelMap,
			HttpSession session) {
		LOGGER.info("Start add new Quote");

		User sessionUser = (User) session.getAttribute("sessionUser");
		Book currentBook = bookService.getBook(currentBookId);

		Quote userQuote = new Quote();
		userQuote.setQuote(quote);
		userQuote.setIdUser(sessionUser.getIdUser());
		userQuote.setBook(currentBook);
		quoteService.saveQuote(userQuote);

		modelMap.addAttribute("currentBook", currentBook);
		modelMap.addAttribute("bookQuotesList", quoteService.getBookQuotes(currentBookId));

		return quote;
	}

	@RequestMapping(value = "/ajaxSe}", method = RequestMethod.GET)
	@ResponseBody
	public String viewBook(@RequestParam String quote, ModelMap modelMap) {
		System.out.println("In ajaxSE");
		return quote;
	}
}
