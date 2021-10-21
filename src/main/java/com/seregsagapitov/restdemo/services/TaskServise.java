package com.seregsagapitov.restdemo.services;


import com.seregsagapitov.restdemo.entities.Task;
import com.seregsagapitov.restdemo.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServise {
    private TasksRepository tasksRepository;


    @Autowired
    public void setTasksRepository(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }




    public List<Task> getAllTasks(){
        return (List<Task>) tasksRepository.findAll();
    }

    public Task getById(Long id){
        return tasksRepository.findById(id).orElse(null);
    }

    public Task save(Task task){
        task.setId(0L);
        return tasksRepository.save(task);
    }

    public Task update(Task task){
        return  tasksRepository.save(task);
    }

    public int delete(Task task){
        tasksRepository.deleteById(task.getId());
        return 200;
    }
}
