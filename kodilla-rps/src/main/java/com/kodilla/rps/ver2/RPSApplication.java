package com.kodilla.rps.ver2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RPSApplication {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String line = scanner.nextLine();
                GameCommand command = GameCommand.of(line);
                GameCommand pcCommand = pcCommand();

                if (command == GameCommand.QUITE) {
                    System.out.println("Quite game");
                    break;
                }

                if (isDraw(command, pcCommand)) {
                    System.out.println("Draw");
                } else if (isFirstWin(command, pcCommand)) {
                    System.out.println("User win");
                } else {
                    System.out.println("PC win");
                }


                System.out.println(String.format("command => %s, pc => %s", command, pcCommand));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


            private static boolean isFirstWin (GameCommand a, GameCommand b){
                return a == GameCommand.PAPER && b == GameCommand.ROCK
                        || a == GameCommand.SCISSORS && b == GameCommand.PAPER
                        || a == GameCommand.ROCK && b == GameCommand.SCISSORS;
            }

            private static boolean isDraw (GameCommand a, GameCommand b){
                return a == b;
            }

            private static GameCommand pcCommand () {
                List<GameCommand> allowedCommands = Arrays.asList(GameCommand.ROCK,GameCommand.SCISSORS, GameCommand.PAPER);

                return allowedCommands.get(getRandomNumber(0, 3));
            }

            static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) +min);
            }
        }

