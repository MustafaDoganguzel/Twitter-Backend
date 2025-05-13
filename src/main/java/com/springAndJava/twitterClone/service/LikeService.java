package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Like;

import java.util.List;

public interface LikeService {

    Like findById(Long id);
    List<Like> findAll();
    Like save(Like like);
    Like delete(Long id);
}
