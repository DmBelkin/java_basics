package com.example.todolist.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todolist")
public class ToDo {

    public ToDo(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime creationtime;

    private boolean isdone;

    private String title;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationtime;
    }

    public void setCreationTime(LocalDateTime creationtime) {
        this.creationtime = creationtime;
    }

    public boolean isDone() {
        return isdone;
    }

    public void setDone(boolean done) {
        isdone = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
