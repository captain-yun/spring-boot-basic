package com.kitri.springbasicboot.project.todo;

public class Todo {
    int id;
    String todo;
    String done;

    public Todo(int id, String todo, String done) {
        this.id = id;
        this.todo = todo;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
