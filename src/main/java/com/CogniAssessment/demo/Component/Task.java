package com.CogniAssessment.demo.Component;

public class Task {
    private int id;
    private String name;
    private String desc;
    private String status;

    public Task(int id, String name, String desc, String status){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
    }

    public void editStatus(String edit){
        this.status = edit;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
    public String getStatus(){
        return status;
    }
}
