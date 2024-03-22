package com.firstproject.demo.controllers;

import com.firstproject.demo.services.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    @Autowired
    private Calculator calculator;

    public AddController() {

        System.out.println("Creando Controller Add");
    }

    @GetMapping("/sumar")
    public String sumar() {
        int a = 5;
        int b = 10;

        return "La suma de los numeros " + a + " y " + b + " es " + calculator.add(a, b);
    }
}
