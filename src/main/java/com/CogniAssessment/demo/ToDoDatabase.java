package com.CogniAssessment.demo;

import java.util.ArrayList;
import java.util.List;

import com.CogniAssessment.demo.Component.Task;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoDatabase {
    private List<Task> Database = new ArrayList<>();
    private int counter = 1;

    @RequestMapping("/add/{name}/{desc}/{status}")
    public List<Task> addTask(@PathVariable String name,
                        @PathVariable String desc, @PathVariable String status){
        System.out.println("Works");
        Task createdTask = new Task(counter,name,desc,status);
        Database.add(createdTask);
        counter++;
        return Database;
    }

    @RequestMapping("/remove/{id}")
    public List<Task> removeTask(@PathVariable int id){
        for(Task task : Database){
            if(task.getId()== id){
                Database.remove(task);
                break;
            }
        }
        return Database;
    }

}
