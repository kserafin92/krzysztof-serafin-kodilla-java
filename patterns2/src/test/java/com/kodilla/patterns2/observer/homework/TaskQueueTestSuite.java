package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskQueueTestSuite {

    @Test
    public void testUpdate() {
        // Given
        TaskQueue johnTasks = new TaskQueue("John Doe");
        TaskQueue janeTasks = new TaskQueue("Jane Doe");
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        johnTasks.registerObserver(mentor1);
        janeTasks.registerObserver(mentor2);
        johnTasks.registerObserver(mentor2);

        // When
        johnTasks.addTask("Task 1");
        johnTasks.addTask("Task 2");
        janeTasks.addTask("Task 3");
        johnTasks.addTask("Task 4");
        janeTasks.addTask("Task 5");

        // Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(5, mentor2.getUpdateCount());
    }
}
