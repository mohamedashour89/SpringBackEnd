package com.anchorsbiz.basic.mapper;

import org.springframework.stereotype.Component;
import com.anchorsbiz.basic.dto.TodoDTO;
import com.anchorsbiz.basic.entity.Todo;
import java.util.List;
import java.util.stream.Collectors;


@Component

public class TodoMapper {
    public TodoDTO toDTO(Todo entity) {
        if (entity == null){
            return null;
        }

        TodoDTO dto = new TodoDTO();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setAssigner(entity.getAssigner());
        dto.setAssignee(entity.getAssignee());
        dto.setTargetDate(entity.getTargetDate());
        dto.setStatus(entity.getStatus());
        return dto;
    }


    public Todo toEntity(TodoDTO dto) {
        if(dto == null) {
            return null;
        }

        Todo entity = new Todo();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setAssigner(dto.getAssigner());
        entity.setAssignee(dto.getAssignee());
        entity.setTargetDate(dto.getTargetDate());
        entity.setStatus(dto.getStatus());
        return entity;

    }

    public List<TodoDTO> toDTOList(List<Todo> entities){
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Todo> toEntityList(List<TodoDTO> dtos){
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}





