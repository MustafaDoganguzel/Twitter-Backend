package com.springAndJava.twitterClone.controller;

import com.springAndJava.twitterClone.entity.Like;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.service.LikeService;
import com.springAndJava.twitterClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;
    private final UserService userService;

    @Autowired
    public LikeController(LikeService likeService, UserService userService) {
        this.likeService = likeService;
        this.userService = userService;
    }


}
