package com.kodilla.rps.FinalVersion;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        System.out.println("Enter the number of rounds to win:");
        int roundsToWin = scanner.nextInt();

        RpsGame game = new RpsGame(roundsToWin);
        game.startGame();

        System.out.println("Game is Over");
    }

}
