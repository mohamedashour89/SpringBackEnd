package com.anchorsbiz.basic.mapper;

import org.springframework.stereotype.Component;
import com.anchorsbiz.basic.dto.UserDTO;
import com.anchorsbiz.basic.entity.User;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDTO(User entity){
        if(entity == null){
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        return dto;
        }

        public User toEntity(UserDTO dto){
            if(dto == null){
                return null;
            }

            User entity = new User();
            entity.setUsername(dto.getUsername());
            entity.setPassword(dto.getPassword());
            entity.setEmail(dto.getEmail());
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity.setFirstName(dto.getFirstName());
            entity.setLastName(dto.getLastName());
            entity.setAddress(dto.getAddress());
            return entity;
        }

        public List<UserDTO> toDTOList(List<User> entities){
            return entities.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }

        public List<User> toEntityList(List<UserDTO> dtos){
            return dtos.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());

        }

    
}
