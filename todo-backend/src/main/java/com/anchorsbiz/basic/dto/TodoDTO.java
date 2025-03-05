package com.anchorsbiz.basic.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TodoDTO {
    private String title;
    private String description;
    private String assigner;
    private String assignee;
    private LocalDate targetDate;
    private String status;
}

