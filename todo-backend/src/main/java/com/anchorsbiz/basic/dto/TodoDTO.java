package com.anchorsbiz.basic.dto;

import java.time.LocalDate;


public class TodoDTO {
    private String title;
    private String description;
    private String assigner;
    private String assignee;
    private LocalDate targetDate;
    private String status;

    // Getter and settters
    public String getTitle() { return title;}
    public void setTitle(String title) {this.title = title;}


    public String getDescription() { return description;}
    public void setDescription(String description) {this.description = description;}

    public String getAssigner() { return assigner;}
    public void setAssigner (String assigner){this.assigner = assigner;}

    public String getAssignee() { return assignee;}
    public void setAssignee (String assignee){this.assignee = assignee;}

    public LocalDate getTargetDate() { return targetDate;}
    public void setTargetDate(LocalDate targetDate){this.targetDate = targetDate;}

    public String getStatus() { return status;}
    public void setStatus (String status) {this.status = status;}




}

