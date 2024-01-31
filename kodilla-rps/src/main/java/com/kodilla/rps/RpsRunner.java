package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            System.out.print("Your Name: ");
            String playerName = scanner.nextLine();

            System.out.print("Rounds to win: ");
            int roundsToWin = scanner.nextInt();

            int playerWins = 0;
            int computerWins = 0;

            while (true) {
                System.out.println("1 - rock");
                System.out.println("2 - paper");
                System.out.println("3 - scissor");
                System.out.println("x - end game");
                System.out.println("n - new game");

                System.out.print("Select key: ");
                char choice = scanner.next().charAt(0);

                if (choice == 'x') {
                    System.out.print("Are you sure? (yes/no): ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        break;
                    }
                } else if (choice == 'n') {
                    System.out.print("Are you sure? (yes/no): ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("yes")) {
                        playerWins = 0;
                        computerWins = 0;
                    }
                } else if (choice >= '1' && choice <= '3') {
                    int playerMove = Integer.parseInt(String.valueOf(choice));
                    int computerMove = random.nextInt(3) + 1;

                    System.out.println(playerName + " " + moveToString(playerMove));
                    System.out.println("Computer " + moveToString(computerMove));

                    int result = determineWinner(playerMove, computerMove);
                    if (result == 1) {
                        playerWins++;
                    } else if (result == -1) {
                        computerWins++;
                    }

                    System.out.println(playerName + " " + playerWins + " : " + computerWins + " Computer");

                    if (playerWins == roundsToWin || computerWins == roundsToWin) {
                        System.out.println("\n*** Game is OVer ***");
                        System.out.println(playerName + " " + playerWins + " : " + computerWins + " Computer");
                        System.out.println(playerWins == roundsToWin ? "You WIn!" : "Computer win ;(");

                    }
                } else {
                    System.out.println("Wrong key, try again.");
                }
            }
        }

        private static String moveToString(int move) {
            switch (move) {
                case 1:
                    return "rock";
                case 2:
                    return "paper";
                case 3:
                    return "scissor";
                default:
                    return "error";
            }
        }

        private static int determineWinner(int playerMove, int computerMove) {
            if (playerMove == computerMove) {
                System.out.println("draw");
                return 0;
            }

            if ((playerMove == 1 && computerMove == 3) ||
                    (playerMove == 2 && computerMove == 1) ||
                    (playerMove == 3 && computerMove == 2)) {
                System.out.println("You Win!");
                return 1;
            } else {
                System.out.println("Computer Win");
                return -1;
            }
        }
    }
