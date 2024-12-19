package com.zoi4erom.blog.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<E> {
        Optional<E> findById(Long id);

        List<E> findAll();

        void save(E entity);

        void delete(Long id);
}
