package com.anchorsbiz.basic.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;


@Data
public class NoteDTO {

    @NotBlank (message = "Please enter the Note's title")
    private String title;

    @NotBlank (message = "please enter the Note's description")
    private String description;
    
}
