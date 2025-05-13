package com.springAndJava.twitterClone.repository;

import com.springAndJava.twitterClone.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
