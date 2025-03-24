package com.anchorsbiz.basic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anchorsbiz.basic.entity.Todo;

import jakarta.transaction.Transactional;


public interface TodoRepository extends JpaRepository <Todo, Long> {
    
// custom query data for the search results
    @Query("SELECT t FROM Todo t WHERE t.status = 'PENDING'")
    List<Todo> getAllTodos();

// custom query data for the insert 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO todo (title, description, assigner, assignee, target_date, status) " +
            "VALUES (:#{#todo.title}, :#{#todo.description}, :#{#todo.assigner}, " +
            ":#{#todo.assignee}, :#{#todo.targetDate}, :#{#todo.status}) ",
            nativeQuery = true)
    void insertTodo(@Param("todo") Todo todo);

    @Query(value = "SELECT * FROM todo ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Todo getLastInsertedTodo();


// custom query data for the delete
    @Modifying
    @Transactional
    @Query("DELETE FROM Todo t WHERE id = : id")
    void deleteTodoById(@Param("id") Long id);




}

// create, delete, update, find by id 직접 여기서 구현 
 
   