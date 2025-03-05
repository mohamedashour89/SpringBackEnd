package com.anchorsbiz.basic.service;

import org.springframework.stereotype.Service;
import com.anchorsbiz.basic.repository.TodoRepository;
import com.anchorsbiz.basic.mapper.TodoMapper;
import com.anchorsbiz.basic.entity.Todo;
import com.anchorsbiz.basic.dto.TodoDTO;
import java.util.List;
import com.anchorsbiz.basic.exception.ResourceNotFoundException;


@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper){
        this.todoMapper = todoMapper;
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> getAllTodo(){
        List<Todo> todos = todoRepository.getAllTodos();
        return todoMapper.toDTOList(todos);
    }

    public TodoDTO createTodo(TodoDTO todoDTO){
        Todo todo = todoMapper.toEntity(todoDTO);
        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toDTO(savedTodo);
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Todo existingTodo = todoRepository.findById(id).
        orElseThrow( () -> new ResourceNotFoundException("Todo not found with id: " + id));

        existingTodo.setTitle(todoDTO.getTitle());
        existingTodo.setDescription(todoDTO.getDescription());
        existingTodo.setAssigner(todoDTO.getAssigner());
        existingTodo.setAssignee(todoDTO.getAssignee());
        existingTodo.setTargetDate(todoDTO.getTargetDate());
        existingTodo.setStatus(todoDTO.getStatus());


        Todo updatedTodo = todoRepository.save(existingTodo);
        return todoMapper.toDTO(updatedTodo);

        
    }







    public void deleteTodo(Long id){
        if (!todoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Todo not found with thid id: " + id);
        }
        todoRepository.deleteById(id);
    }

 
    // public TodoDTO createTodo(TodoDTO todoDTO) {
    //     if (todoDTO == null) {
    //         throw new IllegalArgumentException("TodoDTO cannot be null");
    //     }
    
    //     try {
    //         Todo todo = todoMapper.toEntity(todoDTO);
    //         Todo savedTodo = todoRepository.save(todo);  // Fixed typo in variable name
    //         return todoMapper.toDTO(savedTodo);
    //     } catch (Exception e) {
    //         throw new RuntimeException("Failed to create todo", e);
    //     }
    // }











    
}
