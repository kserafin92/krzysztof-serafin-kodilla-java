package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("Forum User :test OK");
        } else {
            System.out.println("Forum User :^XError!");
        }
        Calculator calculator = new Calculator();

        int addResult = calculator.add(10, 20);
        System.out.println("Add Test 10+20 " + (addResult == 30 ? "Test OK" : "Error"));

        int subtractResult = calculator.subtract(10, 20);
        System.out.println("Subtract Test 10-20 " + (subtractResult == -10 ? "Test OK" : "Error"));
    }
}
