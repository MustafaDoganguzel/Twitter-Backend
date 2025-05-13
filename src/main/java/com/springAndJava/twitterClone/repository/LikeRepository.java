package com.springAndJava.twitterClone.repository;

import com.springAndJava.twitterClone.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
