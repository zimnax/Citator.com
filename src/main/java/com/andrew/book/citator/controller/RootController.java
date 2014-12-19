package com.andrew.book.citator.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andrew.book.citator.entity.User;

@Controller
@RequestMapping("/")
public class RootController {
    private static final Logger LOGGER = Logger.getLogger(Authorization.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String checkIsSessionUserExist(HttpSession session) {
        LOGGER.info("WELCOME!!");
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser != null) {
            LOGGER.info("Start sign in with session user");
            return "redirect:/" + sessionUser.getUsername();
        }
        return "index";
    }

}
