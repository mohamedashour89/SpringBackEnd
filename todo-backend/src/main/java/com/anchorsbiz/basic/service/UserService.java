package com.anchorsbiz.basic.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.anchorsbiz.basic.dto.UserDTO;
import com.anchorsbiz.basic.entity.User;
import com.anchorsbiz.basic.repository.UserRepository;
import com.anchorsbiz.basic.mapper.UserMapper;
import com.anchorsbiz.basic.exception.UserAlreadyExistsException;
import com.anchorsbiz.basic.exception.EmailAlreadyExistsException;
import com.anchorsbiz.basic.dto.LoginDTO;
import com.anchorsbiz.basic.exception.ResourceNotFoundException;
import com.anchorsbiz.basic.exception.InvalidCredentialsException;
import com.anchorsbiz.basic.util.JwtUtil;
import com.anchorsbiz.basic.dto.LoginResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    // check the user name is unique and encrypt the password
    public void signup(UserDTO userDTO){
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new UserAlreadyExistsException("This User Name is already exists, Please try another one");
        }

        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new EmailAlreadyExistsException("This Email is already taken, Please try another Email address");
        }

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
    }


    public LoginResponseDTO login (LoginDTO loginDTO){ //UserDTO
        log.debug("attempting login for user: {}", loginDTO.getUsername());
        User user = userRepository.findByUsername(loginDTO.getUsername())
            .orElseThrow(() -> new ResourceNotFoundException("Please check your username and password"));

        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("please check your username and password");
        }

       // return ("user login is success");
       String token = jwtUtil.generateToken(user.getId());
       return new LoginResponseDTO(token, userMapper.toDTO(user));
    }



    
}
