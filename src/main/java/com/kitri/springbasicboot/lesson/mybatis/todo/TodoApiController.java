package com.kitri.springbasicboot.lesson.mybatis.todo;

import com.kitri.springbasicboot.lesson.mybatis.mappers.TodoMapper;
import com.kitri.springbasicboot.lesson.mybatis.todo.domain.TodoRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    static HashMap<Integer, TodoRequest> todos = new HashMap<>() ;
    TodoMapper mapper;

    static int id = 10;
    static {

    }
    @GetMapping("")
    public ArrayList<TodoRequest> todos() {
        return new ArrayList<>(todos.values());
    }
    @PostMapping
    public TodoRequest add(@RequestBody TodoRequest todo) {
//        todo.setId(id);
        todos.put(id++, todo);
        return todos.get(id - 1);
    }

    @PutMapping("/{id}")
    public TodoRequest toggleCompleted(@PathVariable int id) {
        TodoRequest todo = todos.get(id);
        if (todo.getDone().equals("false")) {
            todo.setDone("true");
        } else {
            todo.setDone("false");
        }
        return todos.get(id);
    }
    @DeleteMapping("/{id}")
    public TodoRequest delete(@PathVariable int id) {
        return todos.remove(id);
    }
}
