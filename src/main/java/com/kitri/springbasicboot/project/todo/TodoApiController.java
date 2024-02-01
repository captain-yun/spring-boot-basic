package com.kitri.springbasicboot.project.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    static HashMap<Integer, Todo> todos = new HashMap<>() ;
    static int id = 10;
    static {
        todos.put(1, new Todo(1, "코테 문제 5개 풀기", "false"));
        todos.put(2, new Todo(2, "스프링DI 개념 복습", "false"));
        todos.put(3, new Todo(3, "아시안컵 보기", "false"));
        todos.put(4, new Todo(4, "영어단어 100개 외우기", "true"));
        todos.put(5, new Todo(5, "옥길이랑 밥약속", "false"));
    }
    @GetMapping("")
    public ArrayList<Todo> todos() {
        return new ArrayList<>(todos.values());
    }
    @PostMapping
    public Todo add(@RequestBody Todo todo) {
        todo.setId(id);
        todos.put(id++, todo);
        return todos.get(id - 1);
    }

    @PutMapping("/{id}")
    public Todo toggleCompleted(@PathVariable int id) {
        Todo todo = todos.get(id);
        if (todo.getDone().equals("false")) {
            todo.setDone("true");
        } else {
            todo.setDone("false");
        }
        return todos.get(id);
    }
    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable int id) {
        return todos.remove(id);
    }
}
