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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.service.UserService;

@Controller
@RequestMapping("/authorizeme")
public class Authorization {
    private static final Logger LOGGER = Logger.getLogger(Authorization.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAuthorizationView() {
        return "authorization";
    }

    @RequestMapping(value = "{user}", method = RequestMethod.POST)
    public String authorizeMe(@RequestParam String email, @RequestParam String password,
            RedirectAttributes redirectAttrs, ModelMap modelMap, HttpSession session) {
        LOGGER.info("Start authorize user");

        User foundedUser = userService.foundUserByEmail(email);

        if (foundedUser != null) {
            LOGGER.info("User with email {" + email + "} exist in dstabase");
            if (password.equals(foundedUser.getPassword())) {
                redirectAttrs.addFlashAttribute("username", foundedUser.getUsername());
                redirectAttrs.addFlashAttribute("email", foundedUser.getEmail());
                redirectAttrs.addFlashAttribute("nickname", foundedUser.getNickname());

                session.setAttribute("sessionUser", foundedUser);

                return "redirect:/" + foundedUser.getUsername();
            }
            LOGGER.info("Passwords does not match");
            modelMap.addAttribute("userPasswordException", "Invalid password");
            return "authorization";
        }
        LOGGER.info("Can't find user with current email ");
        modelMap.addAttribute("userEmailException", "User with current email does not exist");
        return "authorization";
    }

    @RequestMapping(value = "/validateUser", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxTest(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
        User foundedUser = userService.foundUserByEmail(email);
        if (foundedUser != null) {
            if (password.equals(foundedUser.getPassword())) {
                return "success";
            }
            return "fail";
        } else {
            return "fail";
        }
    }

}
