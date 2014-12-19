package com.andrew.book.citator.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrew.book.citator.entity.User;
import com.andrew.book.citator.repositories.UserRepository;
import com.andrew.book.citator.service.UserService;

@Component
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    public void registerNewUser(User user) {
        userRepository.save(user);
    }

    public User foundUserByName(String username) {
        LOGGER.info("Start looking for user {" + username + "} in database");
        return userRepository.getUserByName(username);
    }

    public User foundUserByEmail(String email) {
        LOGGER.info("Start looking for email {" + email + "} in database");
        return userRepository.getUserByEmail(email);
    }
}
