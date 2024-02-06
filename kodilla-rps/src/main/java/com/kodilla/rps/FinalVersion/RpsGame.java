package com.kodilla.rps.FinalVersion;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    private final Scanner scanner;
    private final Random random;
    private int userWins;
    private int computerWins;
    private int roundsToWin;

    public RpsGame(int roundsToWin) {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.userWins = 0;
        this.computerWins = 0;
        this.roundsToWin = roundsToWin;
    }

    public void startGame() {
        System.out.println("Welcome to Rock-Paper-Scissors game!");

        while (!isGameFinished()) {
            System.out.println("Choose your move:");
            System.out.println("1 - Rock");
            System.out.println("2 - Paper");
            System.out.println("3 - Scissors");
            System.out.println("x - Quit");
            System.out.println("n - Start a new game");

            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("x")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    endGame();
                }
            } else if (userInput.equalsIgnoreCase("n")) {
                System.out.println("Are you sure you want to start a new game? (y/n)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    resetGame();
                }
            } else {
                playRound(GameCommand.of(userInput));
            }
        }
    }

    private void playRound(GameCommand userMove) {
        GameCommand computerMove = getRandomMove();

        System.out.println("Your move: " + userMove);
        System.out.println("Computer's move: " + computerMove);

        if (userMove == computerMove) {
            System.out.println("It's a draw!");
        } else if ((userMove == GameCommand.ROCK && computerMove == GameCommand.SCISSORS) ||
                (userMove == GameCommand.PAPER && computerMove == GameCommand.ROCK) ||
                (userMove == GameCommand.SCISSORS && computerMove == GameCommand.PAPER)) {
            System.out.println("You win this round!");
            userWins++;
        } else {
            System.out.println("Computer wins this round!");
            computerWins++;
        }

        System.out.println("Current score - You: " + userWins + ", Computer: " + computerWins);
    }

    private GameCommand getRandomMove() {
        int randomNumber = random.nextInt(3) + 1;
        return GameCommand.of(String.valueOf(randomNumber));
    }

    private boolean isGameFinished() {
        return userWins >= roundsToWin || computerWins >= roundsToWin;
    }

    private void endGame() {
        System.out.println("Game over!");
        System.out.println("Final score - You: " + userWins + ", Computer: " + computerWins);
        System.exit(0);
    }

    private void resetGame() {
        userWins = 0;
        computerWins = 0;
        System.out.println("Starting a new game!");
    }
}