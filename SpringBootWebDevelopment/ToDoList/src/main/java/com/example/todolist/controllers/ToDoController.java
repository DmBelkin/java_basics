package com.example.todolist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todolist.pojo.ToDo;
import com.example.todolist.repos.TodoRepo;

import java.time.LocalDateTime;

@RestController
public class ToDoController {

    @Autowired
    TodoRepo repo;

    @GetMapping(value = "/tasks")
    public Iterable<ToDo> tasks() {
        Iterable<ToDo> todos = repo.findAll();
        return todos;
    }

    //разобраться, почему нет доступа к параметрам методов

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity searchById(@PathVariable("id") int id) {
        ToDo toDo = repo.findByid(id);
        if (toDo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(toDo, HttpStatus.OK);
    }


    @PostMapping(value = "/tasks")
    public ResponseEntity add(@RequestParam String title,
                              @RequestParam String description) {
        ToDo toDo = new ToDo();
        toDo.setTitle(title);
        toDo.setCreationTime(LocalDateTime.now());
        toDo.setDone(false);
        toDo.setDescription(description);
        repo.save(toDo);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PatchMapping(value = "/tasks")
    public ResponseEntity correction(@RequestParam("id") int id,
                                     @RequestParam boolean isdone,
                                     @RequestParam String title,
                                     @RequestParam String description) {
        ToDo toDo = repo.findByid(id);
        if (toDo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (!title.equals("")) {
            toDo.setTitle(title);
        } else {
            toDo.setTitle(toDo.getTitle());
        }
        if (!description.equals("")) {
            toDo.setDescription(description);
        } else {
            toDo.setDescription(toDo.getDescription());
        }
        toDo.setDone(isdone);
        repo.save(toDo);
        return new ResponseEntity(toDo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/tasks")
    public ResponseEntity delete(@RequestParam("id") int id) {
        ToDo toDo = repo.findByid(id);
        if (toDo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        repo.delete(toDo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
