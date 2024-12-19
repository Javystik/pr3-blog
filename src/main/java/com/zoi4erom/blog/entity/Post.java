package com.zoi4erom.blog.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
        private Long id;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private String slug;
        private User author;
}
