package com.springAndJava.twitterClone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tweet" , schema= "public")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String content;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Retweet>retweets = new ArrayList<>();


}
