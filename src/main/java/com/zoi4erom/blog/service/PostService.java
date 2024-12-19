package com.zoi4erom.blog.service;

import com.zoi4erom.blog.entity.Post;
import com.zoi4erom.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
        private final PostRepository postRepository;

        @Autowired
        public PostService(PostRepository postRepository) {
                this.postRepository = postRepository;
        }

        public List<Post> getAllPosts() {
                return postRepository.findAll();
        }

        public Post getPostById(Long id) {
                return postRepository.findById(id).orElse(null);
        }

        public void createPost(Post post) {
                postRepository.save(post);
        }

        public void deletePost(Long id) {
                postRepository.delete(id);
        }
}
