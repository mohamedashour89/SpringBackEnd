package com.anchorsbiz.basic.service;


import org.springframework.stereotype.Service;
import com.anchorsbiz.basic.repository.TodoRepository;
import com.anchorsbiz.basic.entity.Todo;
import java.util.List;


@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo deleteTodo(Todo todo){
        todoRepository.delete(todo);
        return todo;
    }

    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }








    
}
