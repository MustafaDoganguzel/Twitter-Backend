package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Tweet;

import java.util.List;

public interface TweetService {
    Tweet findById(Long id);
    List<Tweet> findAll();
    Tweet save(Tweet tweet);
    Tweet delete(Long id);
}
