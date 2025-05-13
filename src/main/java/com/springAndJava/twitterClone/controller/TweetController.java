package com.springAndJava.twitterClone.controller;

import com.springAndJava.twitterClone.entity.Tweet;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.service.TweetService;
import com.springAndJava.twitterClone.service.UserService;
import dto.TweetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    private final TweetService tweetService;
    private final UserService userService;

    public TweetController(TweetService tweetService, UserService userService) {
        this.tweetService = tweetService;
        this.userService = userService;
    }

    @Autowired


    @PostMapping
    public Tweet save(@RequestBody Tweet tweet){

      Long userId = tweet.getUser().getId(); //Gelen tweet in user id'sini aldik
      User user = userService.findById(userId); // userId'li user'i bulduk

      if (user== null){
          throw new RuntimeException("User not found with id" + userId);
      }

      tweet.setUser(user); // tweete user i set ettik
      Tweet savedTweet = tweetService.save(tweet); // tweeti save ettik
      user.addTweet(savedTweet); // user'a ilgili tweet i ekledik
      userService.save(user);

      return savedTweet;

    }

    @GetMapping("/findByUserId/{userId}")
    public List<Tweet> findByUserId(@PathVariable Long userId){
        User user = userService.findById(userId); // gelen id ile user i bulduk
        if (user== null){
            throw new RuntimeException("User not found with id" + userId);
        }
        return user.getTweets();
    }

    @GetMapping("/findById/{tweetId}")
    public TweetResponse findById(@PathVariable Long tweetId){
        Tweet tweet = tweetService.findById(tweetId);

        return new TweetResponse(tweet.getUser().getUsername(), tweet.getContent());

    }

    @PutMapping("/{id}")
    public TweetResponse update(@PathVariable Long id, @RequestBody Tweet tweet){
        Tweet existingTweet = tweetService.findById(id);

        existingTweet.setContent(tweet.getContent());

        tweetService.save(existingTweet);
        return new TweetResponse(existingTweet.getUser().getUsername(), existingTweet.getContent());

    }

    @DeleteMapping("{id}")
    public TweetResponse delete(@PathVariable Long id){
        Tweet tweet = tweetService.findById(id);
        if (tweet == null){

            throw new RuntimeException("Tweet couldnt find with" + id);
        }
        tweetService.delete(tweet.getId());
            return new TweetResponse(tweet.getUser().getUsername(), tweet.getContent());

    }
}
