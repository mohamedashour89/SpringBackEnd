package com.anchorsbiz.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")        // CORS settings will apply to all URLs that starts with /api ex: /api/todos
            .allowedOrigins("http://localhost:3001") // define who can make requests to the api
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // which HTTP methods are allowed
            .allowedHeaders("content-type", "Authorization","X-Customer-Header", "X-Requested-With") // which HTTP headers are allowed
            .allowCredentials(true); // allow credentials such as cookies (session cookies) 
    }


}