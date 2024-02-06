package com.kitri.springbasicboot.lesson.mybatis.mappers;

import com.kitri.springbasicboot.lesson.mybatis.todo.domain.TodoRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TodoMapper {
    List<TodoRequest> findAll();
    TodoRequest findById(Long id);
    void save();
    void update();
    void deleteById();
}
