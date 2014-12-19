package com.andrew.book.citator.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.service.UserService;

@Controller
@RequestMapping("/registerme")
public class RegistrationController {
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getRegistrationView() {
        return "registration";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String registerNewUser(@RequestParam String username, @RequestParam String email,
            @RequestParam String nickname, @RequestParam String password, @RequestParam String repassword,
            ModelMap modelMap, RedirectAttributes redirectAttrs, HttpSession session) {

        LOGGER.info("Start register user {" + email + "} in database");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);
        userService.registerNewUser(user);

        session.setAttribute("sessionUser", user);

        redirectAttrs.addFlashAttribute("username", username);
        return "redirect:/" + username;
    }
}
