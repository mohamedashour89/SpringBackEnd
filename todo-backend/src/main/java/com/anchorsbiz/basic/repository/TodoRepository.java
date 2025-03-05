package com.anchorsbiz.basic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anchorsbiz.basic.entity.Todo;


public interface TodoRepository extends JpaRepository <Todo, Long> {
    

    @Query("SELECT t FROM Todo t WHERE t.status = 'PENDING'")
    List<Todo> getAllTodos();





}

// create, delete, update, find by id 직접 여기서 구현 
 
   