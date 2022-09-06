package com.CogniAssessment.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private List<Task> taskDatabase;
    private Map<String,Integer> userDatabase = new HashMap<String,Integer>();
    private Map<Integer,List<Task>> uniqueDatabase = new HashMap<Integer,List<Task>>();
    private int currentUser = 0;

    private final AtomicLong userCounter = new AtomicLong();

    @GetMapping()
    public String welcome(){
        return "Welcome to your custom To Do List!";
    }

	@GetMapping("/signin")
	public String user(@RequestParam(value = "name", defaultValue = "Anon") String name) {
        if(userDatabase.containsKey(name))
        {
            currentUser = userDatabase.get(name);
            return "Swapping to an existing user.";
        }
        User createUser = new User(userCounter.incrementAndGet(), name); //Create a new User
        currentUser = userCounter.intValue();
        taskDatabase = new ArrayList<>();//And their corresponding list
        userDatabase.put(name, currentUser);
        uniqueDatabase.put(currentUser, taskDatabase);
        return "New User has been created.";
	}

    @RequestMapping("/add/{name}/{desc}/{status}")
    public String addTask(@PathVariable String name, @PathVariable String desc, 
                          @PathVariable String status){
        int taskCount = 1;
        if(!uniqueDatabase.get(currentUser).isEmpty()){
            taskCount = uniqueDatabase.get(currentUser).size()+1;
        }
        Task createdTask = new Task(taskCount,name,desc,status);
        uniqueDatabase.get(currentUser).add(createdTask);
        return "Request Complete: New Task has been Added";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable int id){
        for(Task task : uniqueDatabase.get(currentUser)){
            if(task.getId()== id){
                taskDatabase.remove(task);
                break;
            }
        }
        return "Request Complete: Task has been Removed";
    }

    @RequestMapping("/display")
    public List<Task> showTasks(){
        return uniqueDatabase.get(currentUser);
    }

    @RequestMapping("/edit/{id}/{status}")
    public String editTask(@PathVariable int id,@PathVariable String status){
        for(Task task : uniqueDatabase.get(currentUser)){
            if(task.getId()== id){
                task.editStatus(status);
                break;
            }
        }
        return "Request Complete: Status on task has been changed";
    }

}
