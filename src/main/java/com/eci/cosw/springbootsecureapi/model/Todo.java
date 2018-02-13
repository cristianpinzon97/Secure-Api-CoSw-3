package com.eci.cosw.springbootsecureapi.model;

public class Todo {

    public  String description="";
    public  int priority=0;
    public  boolean completed=false;


    public Todo(){}

    public Todo(String description,int priority,boolean completed){
        this.completed=completed;
        this.description=description;
        this.priority=priority;
    }

    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getCompleted() {
        return completed;
    }
}
