package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void  testCalculations() {
        calculator.add(2, 2);
        calculator.sub(5, 8);
        calculator.mul(6, 4);
        calculator.div(4,3 );
    }
}
