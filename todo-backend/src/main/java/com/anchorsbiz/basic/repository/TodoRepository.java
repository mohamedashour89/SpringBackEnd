package com.anchorsbiz.basic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anchorsbiz.basic.entity.Todo;


public interface TodoRepository extends JpaRepository <Todo, Long> {
    
    // Find todos due within next N days using @Query
    @Query("SELECT t FROM Todo t WHERE t.targetDate BETWEEN :startDate AND :endDate")
    List<Todo> findTodosDueInRange(
        @Param("startDate") LocalDate startDate, 
        @Param("endDate") LocalDate endDate
    );
}

// create, delete, update, find by id 직접 여기서 구현 
 
   