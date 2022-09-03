package com.CogniAssessment.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.CogniAssessment.demo.Component.Task;
import com.CogniAssessment.demo.Component.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ClientSide {
    private List<Task> Database = new ArrayList<>();
    private int taskCounter = 1;

    private final AtomicLong userCounter = new AtomicLong();

	@GetMapping("/signin")
	public User user(@RequestParam(value = "name", defaultValue = "Anon") String name) {
		return new User(userCounter.incrementAndGet(), name);
	}

    @RequestMapping("/add/{name}/{desc}/{status}")
    public String addTask(@PathVariable String name, @PathVariable String desc, 
                          @PathVariable String status){
        Task createdTask = new Task(taskCounter,name,desc,status);
        Database.add(createdTask);
        taskCounter++;
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
