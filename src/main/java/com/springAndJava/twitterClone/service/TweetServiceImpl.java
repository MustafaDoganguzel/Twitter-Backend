package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Tweet;
import com.springAndJava.twitterClone.repository.TweetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class TweetServiceImpl implements TweetService{

    private final TweetRepository  tweetRepository;
    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet findById(Long id) {
        Optional<Tweet> optional = tweetRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet delete(Long id) {
        Tweet deletedTweet = findById(id);
        tweetRepository.delete(deletedTweet);
        return deletedTweet;
    }
}
