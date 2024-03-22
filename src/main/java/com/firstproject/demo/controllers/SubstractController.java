package com.firstproject.demo.controllers;

import com.firstproject.demo.services.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubstractController {

    @Autowired
    private Calculator calculator;

    public SubstractController() {

        System.out.println("Creando Controller Substract");
    }

    @GetMapping("/restar")
    public String restar() {
        int a = 5;
        int b = 10;

        return "La resta de los numeros " + a + " y " + b + " es " + calculator.substract(a, b);
    }
}
