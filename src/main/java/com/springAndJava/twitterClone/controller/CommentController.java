package com.springAndJava.twitterClone.controller;

import com.springAndJava.twitterClone.entity.Comment;
import com.springAndJava.twitterClone.entity.User;
import com.springAndJava.twitterClone.service.CommentService;
import com.springAndJava.twitterClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/")
    public Comment save(@RequestBody Comment comment){
        Long userId = comment.getUser().getId();
        User user = userService.findById(userId);

        if(user == null){
            throw new RuntimeException("User not found with id" + userId);
        }
        comment.setUser(user);
        Comment savedComment = commentService.save(comment);

        user.addComments(savedComment);
        userService.save(user);

        return savedComment;

    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        Comment existingComment = commentService.findById(id);

        existingComment.setContent(comment.getContent());

        return commentService.save(existingComment);

    }

    @DeleteMapping("/{id}")
    public Comment delete(@PathVariable Long id){
        Comment comment = commentService.findById(id);

        if(comment == null){
            throw new RuntimeException("Comment couldnt find with" + id);
        }
        return commentService.delete(id);

    }

}
