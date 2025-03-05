package com.anchorsbiz.basic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Data
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String description;
        private String assigner;
        private String assignee;
        @Column(name = "target_date")
        private LocalDate targetDate;
        private String status;


        // getters and setters 
        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }

        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title = title;
        }

        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getAssigner(){
            return assigner;
        }
        public void setAssigner(String assigner){
            this.assigner = assigner;
        }
        public String getAssignee(){
            return assignee;
        }
        public void setAssignee(String assignee){
            this.assignee = assignee;
        }

        public LocalDate getTargetDate(){
            return targetDate;
        }
        public void setTargetDate(LocalDate targetDate){
            this.targetDate = targetDate;
        }

        public String getStatus(){
            return status;
        }

        public void setStatus(String status){
            this.status = status;
        }

}
