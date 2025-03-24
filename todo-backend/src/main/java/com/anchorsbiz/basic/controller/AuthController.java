package com.anchorsbiz.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anchorsbiz.basic.dto.UserDTO;
import com.anchorsbiz.basic.service.UserService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import com.anchorsbiz.basic.exception.UserAlreadyExistsException;
import com.anchorsbiz.basic.exception.EmailAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import com.anchorsbiz.basic.exception.InvalidCredentialsException;
import com.anchorsbiz.basic.dto.LoginResponseDTO;
import com.anchorsbiz.basic.dto.LoginDTO;


@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody UserDTO userDTO){
      try { 
        userService.signup(userDTO);
        return ResponseEntity.ok("User created successfully");
      } catch (UserAlreadyExistsException | EmailAlreadyExistsException e){
        throw e;
      } catch (Exception e) {
        log.error("Unexpected error occured during the process of the signup", e);
        throw new RuntimeException("Unexpected error occured during the process of the signup");
      }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO){
      try {
        LoginResponseDTO response = userService.login(loginDTO);
        return ResponseEntity.ok(response);
      } catch(InvalidCredentialsException e){
        throw e;
      } catch (Exception e){
        log.error("Unexpected error occured during the login", e);
        throw new RuntimeException("Unexpected error occured during login");
      }
    }


  

  
}
