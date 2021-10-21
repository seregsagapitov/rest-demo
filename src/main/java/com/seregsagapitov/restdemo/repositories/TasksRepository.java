package com.seregsagapitov.restdemo.repositories;


import com.seregsagapitov.restdemo.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TasksRepository extends CrudRepository<Task, Long> {
}
