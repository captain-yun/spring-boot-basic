package com.kitri.springbasicboot.lesson.mapping;

public class Student {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
