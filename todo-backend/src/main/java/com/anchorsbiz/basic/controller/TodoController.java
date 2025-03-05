package com.anchorsbiz.basic.controller;

import com.anchorsbiz.basic.dto.TodoDTO;
import org.springframework.web.bind.annotation.*;
import com.anchorsbiz.basic.service.TodoService;
import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    
    @GetMapping("/search")
    public List<TodoDTO> getAllTodo() {
        return todoService.getAllTodo();

    }

    @PostMapping("/{create}")
    public TodoDTO createTodo (@RequestBody TodoDTO todoDTO){
        return todoService.createTodo(todoDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        TodoDTO updatedTodo = todoService.updateTodo(id, todoDTO);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }


    

    

    
}


// login 
// signup
// lougout
// user authentication