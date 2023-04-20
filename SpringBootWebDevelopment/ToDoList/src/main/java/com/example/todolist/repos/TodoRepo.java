package com.example.todolist.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.todolist.pojo.ToDo;

import java.util.List;

public interface TodoRepo extends CrudRepository<ToDo, Integer> {

    ToDo findByid(int id);

}
