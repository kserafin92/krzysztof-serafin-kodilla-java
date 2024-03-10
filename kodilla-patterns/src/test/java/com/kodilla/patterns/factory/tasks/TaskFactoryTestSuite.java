package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        // given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask("SHOPPING", "Buy groceries", "Milk", "2.0");
        assertFalse(shoppingTask.isTaskExecuted());

        // when
        shoppingTask.executeTask();


        // then
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        // given
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.createTask("PAINTING", "Paint the room", "Blue", "Walls");
        assertFalse(paintingTask.isTaskExecuted());

        // when
        paintingTask.executeTask();

        // then
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        // given
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.createTask("DRIVING", "Go for a trip", "Mountains", "Car");
        assertFalse(drivingTask.isTaskExecuted());

        // when
        drivingTask.executeTask();

        // then
        assertTrue(drivingTask.isTaskExecuted());
    }

}

