package com.estsoft.springdemoproject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    // select * from comments where id = 1
    // Comment comment = commentRepository.findById(1);
    // comment.getPost()
    // => SELECT * FROM posts WHERE id = (SELECT post_id FROM comments WHERE id = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "content")
    private String content;
    @Column(name = "is_deleted", columnDefinition = "TINYINT(1)")
    private Boolean isDeleted;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
