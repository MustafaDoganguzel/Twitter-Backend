package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User save(User user);
    User delete(Long id);


}
