package com.zoi4erom.blog.repository;

import com.zoi4erom.blog.entity.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostRepository implements Repository<Post> {
        private final List<Post> posts = new ArrayList<>();

        @Override
        public Optional<Post> findById(Long id) {
                return posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst();
        }

        @Override
        public List<Post> findAll() {
                return posts;
        }

        @Override
        public void save(Post post) {
                posts.add(post);
        }

        @Override
        public void delete(Long id) {
                posts.removeIf(post -> post.getId().equals(id));
        }
}