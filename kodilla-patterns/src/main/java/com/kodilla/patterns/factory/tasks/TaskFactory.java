package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public Task createTask(String taskType, String taskName, String... parameters) {
        switch (taskType.toUpperCase()) {
            case "SHOPPING":
                return new ShoppingTask(taskName, parameters[0], Double.parseDouble(parameters[1]));
            case "PAINTING":
                return new PaintingTask(taskName, parameters[0], parameters[1]);
            case "DRIVING":
                return new DrivingTask(taskName, parameters[0], parameters[1]);
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
    }
}
