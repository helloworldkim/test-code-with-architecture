package com.example.demo.post.service.port;

import com.example.demo.post.domain.Post;
import com.example.demo.post.infra.PostEntity;

import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(long id);

    Post save(Post post);
}
