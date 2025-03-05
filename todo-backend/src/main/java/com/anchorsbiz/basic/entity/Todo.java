package com.anchorsbiz.basic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;


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
}
