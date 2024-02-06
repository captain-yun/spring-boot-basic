package com.kitri.springbasicboot.lesson.mybatis.todo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {
    private Long id;
    private String content;
    private String done;
}
