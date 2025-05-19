package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Retweet;
import com.springAndJava.twitterClone.entity.Tweet;

public interface RetweetService {

    Tweet retweet(Tweet tweet);
    Retweet delete(Retweet retweet);
}
