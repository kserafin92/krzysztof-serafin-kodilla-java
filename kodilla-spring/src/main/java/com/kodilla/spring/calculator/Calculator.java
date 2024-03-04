package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private final Display display;

    @Autowired
    public Calculator(Display display) {
        this.display = display;
    }

    public void add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
    }

    public void sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
    }

    public void mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
    }
    public void div(double a, double b) {
        if (b != 0) {
            double result = a / b;
            display.displayValue(result);
        } else {
            System.out.println("Cannot divide by zero");
        }
    }
}

