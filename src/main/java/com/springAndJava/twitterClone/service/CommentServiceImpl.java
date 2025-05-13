package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Comment;
import com.springAndJava.twitterClone.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()){
            return optionalComment.get();
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment delete(Long id) {
        Comment deletedComment = findById(id);
        commentRepository.delete(deletedComment);
        return deletedComment;
    }
}
