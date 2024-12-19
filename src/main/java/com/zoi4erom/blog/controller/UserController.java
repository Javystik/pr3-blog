package com.zoi4erom.blog.controller;

import com.zoi4erom.blog.entity.User;
import com.zoi4erom.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping
        public String listUsers(Model model) {
                List<User> users = userService.findAll();
                model.addAttribute("users", users);
                return "user/list";
        }

        @GetMapping("/{id}")
        public String viewUser(@PathVariable Long id, Model model) {
                Optional<User> user = userService.findById(id);
                if (user.isPresent()) {
                        model.addAttribute("user", user.get());
                        return "user/view";
                }
                return "redirect:/users";
        }

        @GetMapping("/new")
        public String createUserForm(Model model) {
                model.addAttribute("user", new User());
                return "user/form";
        }

        @PostMapping("/save")
        public String saveUser(@ModelAttribute User user) {
                userService.save(user);
                return "redirect:/users";
        }

        @GetMapping("/edit/{id}")
        public String editUser(@PathVariable Long id, Model model) {
                Optional<User> user = userService.findById(id);
                if (user.isPresent()) {
                        model.addAttribute("user", user.get());
                        return "user/form";
                }
                return "redirect:/users";
        }

        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable Long id) {
                userService.delete(id);
                return "redirect:/users";
        }
}
