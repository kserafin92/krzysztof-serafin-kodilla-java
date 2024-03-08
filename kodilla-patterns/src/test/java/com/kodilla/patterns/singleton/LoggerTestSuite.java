package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        // Given
               String logMessage = "Test log message";
                Logger.INSTANCE.log(logMessage);

               // When
               String retrievedLog = Logger.INSTANCE.getLastLog();

               // Then
              assertEquals(logMessage, retrievedLog);
           }

    @Test
    public void testGetLastLogWithMultipleLogs() {
        // Given
        String firstLog = "First log";
        String secondLog = "Second log";
        Logger.INSTANCE.log(firstLog);
        Logger.INSTANCE.log(secondLog);

        // When
        String retrievedLog = Logger.INSTANCE.getLastLog();

        // Then
        assertEquals(secondLog, retrievedLog);
    }
}