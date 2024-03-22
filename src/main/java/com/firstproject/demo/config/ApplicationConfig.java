package com.firstproject.demo.config;

import com.firstproject.demo.services.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Calculator configCalculator() {
        System.out.println("Creando Bean calculator");
        return new Calculator();
    }
}
