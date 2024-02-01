package com.kitri.springbasicboot.lesson.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/students") // localhost:8080/students
public class MappingRestController {
    static HashMap<Long, Student> students = new HashMap<>();
    static {
        students.put(1L, new Student(1L, "박준혁"));
        students.put(2L, new Student(2L, "주나영"));
        students.put(3L, new Student(3L, "김성실"));
        students.put(4L, new Student(4L, "한민선"));
    }

    @GetMapping("/student")
    public String student() {
        return "학생";
    }

    // 학생 1명 조회
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return students.get(id);
    }

    @GetMapping("")
    public ArrayList<Student> getAll() {
        // map의 values -> arraylist
        return new ArrayList<Student>(students.values());
    }

    // 클라이언트에서 요청하는 데이터 타입을 제한하여 매칭
    @PostMapping(path = "", consumes = {"application/json"})
    public Long addStudent() {
        // map의 values -> arraylist
        new Student(5L, "김미성");
        return 5L;
    }
    
    // 서버에서 응답하는 데이터 타입을 제한하여 매칭
    @GetMapping(path = "/produces", produces = {"application/json"})
    public String produces() {
        return "OK";
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String regexp(@PathVariable String name, @PathVariable String version, @PathVariable String ext) {
        return name + version + ext;
    }




}
