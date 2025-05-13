package com.springAndJava.twitterClone.repository;

import com.springAndJava.twitterClone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
