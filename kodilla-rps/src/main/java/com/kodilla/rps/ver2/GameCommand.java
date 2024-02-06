package com.kodilla.rps.ver2;

public enum GameCommand {
    ROCK("rock"), PAPER("paper"), SCISSORS("scissors"), QUITE("q");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public static GameCommand of(String value){
        for(GameCommand command : values()){
            if(command.value.equals(value)){
                return command;
            }
        }

        throw new IllegalArgumentException("Wrong command " +value);
    }
}
