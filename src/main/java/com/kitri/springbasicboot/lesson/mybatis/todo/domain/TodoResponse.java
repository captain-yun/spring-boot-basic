package com.kitri.springbasicboot.lesson.mybatis.todo.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {
    private Long id;
    private String content;
    private String done;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
