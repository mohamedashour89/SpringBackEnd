package com.anchorsbiz.basic.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anchorsbiz.basic.service.SampleService;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/spring/sample")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public String printMessage() {
        return sampleService.printMessage();  
    }

}