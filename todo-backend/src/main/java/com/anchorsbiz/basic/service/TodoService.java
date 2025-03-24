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
        todoRepository.insertTodo(todo);
        Todo savedTodo = todoRepository.getLastInsertedTodo();
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
            throw new ResourceNotFoundException("Todo not found with thiㄴ id: " + id);
        }
        todoRepository.deleteTodoById(id);
    }



    
}
