package com.zoi4erom.blog.repository;

import com.zoi4erom.blog.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository implements Repository<User> {
        private final List<User> users = new ArrayList<>();

        @Override
        public Optional<User> findById(Long id) {
                return users.stream().filter(user -> user.getId().equals(id)).findFirst();
        }

        @Override
        public List<User> findAll() {
                return users;
        }

        @Override
        public void save(User user) {
                users.add(user);
        }

        @Override
        public void delete(Long id) {
                users.removeIf(user -> user.getId().equals(id));
        }

}
