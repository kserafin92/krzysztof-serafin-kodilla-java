package com.kodilla.exception.io;

import com.kodilla.exception.test.ExceptionHandling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondChallengeTestSuite {
    @Test
    public void testExceptionValidInput() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = exceptionHandling.handleException(1.0, 2.0);
        assertEquals("Done!", result);
    }

    @Test
    public void testExceptionInvalidInput() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = exceptionHandling.handleException(2.0, 3.0);
        assertEquals("Exception caught: null", result);
    }

    @Test
    public void testExceptionEdgeCase() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        String result = exceptionHandling.handleException(1.0, 1.5);
        assertEquals("Exception caught: null", result);
    }
}

