package com.seregsagapitov.restdemo.controllers;


import com.seregsagapitov.restdemo.entities.Task;
import com.seregsagapitov.restdemo.services.TaskServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TasksController {
    private TaskServise taskServise;

    @Autowired
    public void setTaskServise(TaskServise taskServise) {
        this.taskServise = taskServise;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskServise.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getOneTask(@PathVariable("id") Long id) {
        return taskServise.getById(id);
    }

    @PostMapping("/tasks")
    public Task addNewTask(@RequestBody Task task) {

        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);

        String dateString = simpleDateFormat.format(new Date());
        task = new Task("created", dateString);
        System.out.println(task.toString());
        return taskServise.save(task);

    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task){
        return taskServise.update(task);
    }

    @DeleteMapping("/tasks")
    public int deleteTask(@RequestBody Task task){
        return taskServise.delete(task);
    }

    public  void updateStatus(Task task){
        task.setStatus("running");
    }

}
