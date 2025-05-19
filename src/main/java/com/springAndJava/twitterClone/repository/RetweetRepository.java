package com.springAndJava.twitterClone.repository;

import com.springAndJava.twitterClone.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {
}
