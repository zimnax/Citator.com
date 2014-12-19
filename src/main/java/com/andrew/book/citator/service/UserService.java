package com.andrew.book.citator.service;

import com.andrew.book.citator.entity.User;

public interface UserService {

    void registerNewUser(User user);

    User foundUserByName(String username);
    
    User foundUserByEmail(String email);

}
