package com.kodilla.exception.test;

public class ExceptionHandling {

    public String handleException(double x, double y) {
        try {
            SecondChallenge secondChallenge = new SecondChallenge();
            return secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            return "Exception caught: " + e;
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}