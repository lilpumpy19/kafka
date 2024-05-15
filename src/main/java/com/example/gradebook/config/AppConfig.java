package com.example.gradebook.config;

import com.example.gradebook.dto.StudentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public StudentDTO studentDto() {
        return new StudentDTO();
    }
}
