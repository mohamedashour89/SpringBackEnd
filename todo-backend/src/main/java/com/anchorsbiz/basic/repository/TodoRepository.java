package com.anchorsbiz.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anchorsbiz.basic.entity.Todo;


public interface TodoRepository extends JpaRepository <Todo, Long> {

}

// create, delete, update, find by id 직접 여기서 구현 
