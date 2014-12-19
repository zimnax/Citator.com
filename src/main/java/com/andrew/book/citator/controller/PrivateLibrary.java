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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andrew.book.citator.entity.Book;
import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.service.BookService;
import com.andrew.book.citator.service.UserService;

@Controller
@RequestMapping("/{username}")
public class PrivateLibrary {
    private static final Logger LOGGER = Logger.getLogger(PrivateLibrary.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPageOfCurrentUser(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttrs) {

        boolean pageOwner = false;
        User sessionUser = (User) request.getSession().getAttribute("sessionUser");

        if (sessionUser == null) {
            return "redirect:/authorizeme";
        }

        String URLusername = StringUtils.substringAfter(request.getServletPath(), "/");
        LOGGER.info("Open privateLibrary page for user {" + URLusername + "}");

        User foundedUser = userService.foundUserByName(URLusername);

        if (foundedUser != null) {
            LOGGER.info("User {" + URLusername + "} exist. Start build dataModel");
            LinkedList<Book> bookList = bookService.getBookList(foundedUser);

            modelMap.addAttribute("userBooksList", bookList);
            modelMap.addAttribute("currentUser", foundedUser);

            if (StringUtils.equalsIgnoreCase(URLusername, sessionUser.getUsername())) {
                LOGGER.info("Current user is a page owner");
                pageOwner = true;
            }
            modelMap.addAttribute("pageOwner", pageOwner);
            return "privateLibrary";
        }
        LOGGER.info("User with username {" + URLusername + "} does not exist.");
        return "errorPage";
    }

    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/authorizeme";
    }

}
