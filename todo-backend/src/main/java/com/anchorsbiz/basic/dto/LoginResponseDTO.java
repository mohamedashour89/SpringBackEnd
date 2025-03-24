package com.anchorsbiz.basic.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String accessToken;
    private UserDTO user;


    public LoginResponseDTO(String accessToken, UserDTO user){
        this.accessToken = accessToken;
        this.user = user;
    }
    
}
