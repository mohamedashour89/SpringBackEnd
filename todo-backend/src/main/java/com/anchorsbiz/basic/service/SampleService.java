package com.anchorsbiz.basic.service;

import org.springframework.stereotype.Service;
import com.anchorsbiz.basic.repository.MessageRepository;
import com.anchorsbiz.basic.entity.Message; 


@Service
public class SampleService {

    // 1. Repository Injection 
    private final MessageRepository messageRepository;

    // 2. Constructor Injection 
    public SampleService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    // 3. update method with database operations 
    public String printMessage() {
        Message message =  new Message();
        message.setContent("ahlb bkom fe masr");
        messageRepository.save(message);
        return message.getContent();

    }

}




/*
 * 
 * Controller → Service → Repository → Database
   (API)    (Logic)    (Data Access)
 * 
 */