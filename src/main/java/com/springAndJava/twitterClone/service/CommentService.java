package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Comment;
import com.springAndJava.twitterClone.entity.User;

import java.util.List;

public interface CommentService {
    Comment findById(Long id);
    List<Comment> findAll();
    Comment save(Comment comment);
    Comment delete(Long id);

}
