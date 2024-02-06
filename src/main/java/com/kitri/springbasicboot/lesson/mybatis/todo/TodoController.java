package com.kitri.springbasicboot.lesson.mybatis.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @GetMapping
    public String todos() {
        return "/project/todo/todos";
    }
}
