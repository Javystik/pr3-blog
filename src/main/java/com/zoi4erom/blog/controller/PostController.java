package com.zoi4erom.blog.controller;

import com.zoi4erom.blog.entity.Post;
import com.zoi4erom.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

        private final PostService postService;

        public PostController(PostService postService) {
                this.postService = postService;
        }

        @GetMapping
        public String listPosts(Model model) {
                List<Post> posts = postService.getAllPosts();
                model.addAttribute("posts", posts);
                return "post/list";
        }

        @GetMapping("/{id}")
        public String viewPost(@PathVariable Long id, Model model) {
                Post post = postService.getPostById(id);
                if (post != null) {
                        model.addAttribute("post", post);
                        return "post/view";
                }
                return "redirect:/posts";
        }

        @GetMapping("/new")
        public String createPostForm(Model model) {
                model.addAttribute("post", new Post());
                return "post/form";
        }

        @PostMapping("/save")
        public String savePost(@ModelAttribute Post post) {
                postService.createPost(post);
                return "redirect:/posts";
        }

        @GetMapping("/edit/{id}")
        public String editPost(@PathVariable Long id, Model model) {
                Post post = postService.getPostById(id);
                if (post != null) {
                        model.addAttribute("post", post);
                        return "post/form";
                }
                return "redirect:/posts";
        }

        @GetMapping("/delete/{id}")
        public String deletePost(@PathVariable Long id) {
                postService.deletePost(id);
                return "redirect:/posts";
        }
}
