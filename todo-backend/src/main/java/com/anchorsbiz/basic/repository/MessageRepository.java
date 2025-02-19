package com.anchorsbiz.basic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.anchorsbiz.basic.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {


    
}
