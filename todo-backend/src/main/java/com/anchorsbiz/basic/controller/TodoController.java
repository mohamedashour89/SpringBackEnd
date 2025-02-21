package com.anchorsbiz.basic.controller;


import org.springframework.web.bind.annotation.*;
import com.anchorsbiz.basic.service.TodoService;
import com.anchorsbiz.basic.entity.Todo;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/todos")

// locahost8080/api/todos/{id} delete
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo (@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }
    
}


// login 
// signup
// lougout
// user authentication