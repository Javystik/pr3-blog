package com.zoi4erom.blog.service;

import com.zoi4erom.blog.entity.User;
import com.zoi4erom.blog.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
                this.userRepository = userRepository;
        }

        public Optional<User> findById(Long id) {
                return userRepository.findById(id);
        }

        public List<User> findAll() {
                return userRepository.findAll();
        }

        public void save(User user) {
                userRepository.save(user);
        }

        public void delete(Long id) {
                userRepository.delete(id);
        }
}
