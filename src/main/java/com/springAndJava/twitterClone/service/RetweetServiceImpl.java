package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Retweet;
import com.springAndJava.twitterClone.entity.Tweet;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.repository.RetweetRepository;
import com.springAndJava.twitterClone.repository.TweetRepository;
import com.springAndJava.twitterClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RetweetServiceImpl implements RetweetService{

    private final RetweetRepository retweetRepository;
    private  final TweetRepository tweetRepository;
    private final UserRepository userRepository;
    @Autowired
    public RetweetServiceImpl(RetweetRepository retweetRepository,
                              TweetRepository tweetRepository,
                              UserRepository userRepository) {
        this.retweetRepository = retweetRepository;
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Tweet retweet(Tweet tweet) {
        Tweet existingTweet = tweetRepository.findById(tweet.getId()).orElseThrow(()->
                new RuntimeException("tweet not found")); // ilgili tiviti bulduk
        User user = userRepository.findById(tweet.getUser().getId()).orElseThrow(()->
                new RuntimeException("user not found")); // tivitin sahibini bulduk
       existingTweet.setRetweetCount(existingTweet.getRetweetCount()+1);
        tweetRepository.save(existingTweet);
        user.addTweet(existingTweet);

        userRepository.save(user);
        return existingTweet;


    }

    @Override
    public Retweet delete(Retweet retweet) {
        return null;
    }
}
