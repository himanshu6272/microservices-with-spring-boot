package com.PostService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    private String postId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "description")
    private String description;
    @OneToMany
    @Transient
    private List<Comment> comments = new ArrayList<>();
}
