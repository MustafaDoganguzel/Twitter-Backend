package com.springAndJava.twitterClone.service;

import com.springAndJava.twitterClone.entity.Like;
import com.springAndJava.twitterClone.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like findById(Long id) {
        Optional<Like> optional = likeRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Like save(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like delete(Long id) {
        Like deletedLike = findById(id);
        likeRepository.delete(deletedLike);
        return deletedLike;
    }


}
