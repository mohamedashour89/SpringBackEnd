package com.anchorsbiz.basic.dto;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.*;

@Data
public class UserDTO {

    @NotBlank(message = "Please enter your first name")
    private String firstName;

    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @NotBlank(message = "Username cannot be blank")
    private String username;



    //ensure the password is between 8 and 16 characters .{8,16}
    //ensure the password contains at least one digit (?=.*[0-9])
    //ensure the password contains at leas one letter (uppercase or lowercase) (?=.*[a-zA-Z])
    //ensure at least one special character case (?=.*\\W)
    //ensure that password does not contain any spaces (?=\S+$)
    @JsonIgnore
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @JsonIgnore
    @NotBlank(message = "Email is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotBlank(message = "Please enter your phone number")
    @Size(min = 10, max = 11, message = "Your phone number must be between 10 and 11 numbers")
    @Pattern (regexp = "^0\\d{9,10}", message = "Please enter a valid phone number")
    private String phoneNumber;

    private String address;


}




