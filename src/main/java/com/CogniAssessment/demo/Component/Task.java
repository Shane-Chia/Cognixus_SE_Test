package com.CogniAssessment.demo.Component;

public class Task {
    private int id;
    private String name;
    private String description;
    private String status;

    public Task(int id, String name, String desc, String status){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return description;
    }
    public String getStatus(){
        return status;
    }
}
