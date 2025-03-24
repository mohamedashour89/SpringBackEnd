package com.anchorsbiz.basic.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @NotBlank(message = "Please enter your username")
    private String username;

    @NotBlank(message = "Please enter your password")
    private String password;

}
