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
    public String addTask(@PathVariable String name, @PathVariable String desc, 
                          @PathVariable String status){
        Task createdTask = new Task(counter,name,desc,status);
        Database.add(createdTask);
        counter++;
        return "Request Complete: New Task has been Added";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable int id){
        for(Task task : Database){
            if(task.getId()== id){
                Database.remove(task);
                break;
            }
        }
        return "Request Complete: Task has been Removed";
    }

    @RequestMapping("/display")
    public List<Task> showTasks(){
        return Database;
    }

    @RequestMapping("/edit/{id}/{status}")
    public String editTask(@PathVariable int id,@PathVariable String status){
        for(Task task : Database){
            if(task.getId()== id){
                task.editStatus(status);
                break;
            }
        }
        return "Request Complete: Status on task has been changed";
    }

}
