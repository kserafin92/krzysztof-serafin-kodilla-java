package com.kodilla.rps.FinalVersion;

public enum GameCommand {
    ROCK("1"), PAPER("2"), SCISSORS("3");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public static GameCommand of(String value) {
        for (GameCommand command : values()) {
            if (command.value.equals(value)) {
                return command;
            }
        }

        throw new IllegalArgumentException("Wrong command " + value);
    }
}