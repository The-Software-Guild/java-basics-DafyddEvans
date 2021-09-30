package org.dafydd.c130.exercises;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static Scanner myScanner = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        int[] totalScore = {0, 0, 0};       // {playerWins, cmpWins, draws}
        int[] score;                        // {playerWins, cmpWins, draws}
        boolean gameOn = true;
        boolean isValid;
        char choice;

        while(gameOn) {
            score = game();
            for(int i = 0; i < 3; i++) {
                totalScore[i] = totalScore[i] + score[i];
            }

            System.out.println("You won " + score[0] + " games, lost " + score[1] + " games and drew " +
                    score[2] + " games.");
            System.out.println("\nIn total you have won " + totalScore[0] + " games, lost " + totalScore[1] +
                    " games and drew " + totalScore[2] + " games.");

            isValid = false;

            while(!isValid) {
                System.out.println("\nWould you like to play again? Y/N");

                choice = myScanner.next().charAt(0);
                choice = Character.toLowerCase(choice);

                if (choice == 'y') {
                    isValid = true;
                }
                else if (choice == 'n') {
                    isValid = true;
                    gameOn = false;
                }
                else {
                    System.out.println("Please enter a valid character");
                }

            }
        }
        System.out.println("Thank you for playing.");
    }

    private static int[] game() {
        int playerWins, cmpWins, draws, numRounds, playerChoice, cmpChoice;
        playerWins = cmpWins = draws = numRounds = playerChoice = 0;
        boolean isValid = false;

        while(!isValid) {
            System.out.println("\nHow many rounds would you like to play? (1-10): ");

            try {
                numRounds = Integer.parseInt(myScanner.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input type, please use numbers only.");
                continue;
            }

            if (numRounds > 0 && numRounds < 11) {
                isValid = true;
            }
            else {
                System.out.println("Please enter a number between 1 and 10");
            }

        }

        System.out.println("Game starting... we will play " + numRounds + " rounds.");

        for(int i = 0; i < numRounds; i++) {
            System.out.println("There are " + (numRounds - i) + " rounds remaining.");
            System.out.println("Do you choose Rock(1), Paper(2) or Scissors(3)?");
            isValid = false;

            while(!isValid) {
                try {
                    playerChoice = Integer.parseInt(myScanner.nextLine());
                }
                catch (NumberFormatException ex) {
                    System.out.println("Invalid input type, please use numbers only.");
                    continue;
                }

                if (playerChoice > 0 && playerChoice < 4) {
                    isValid = true;
                }
                else {
                    System.out.println("Please enter a number between 1 and 3");
                }
            }

            cmpChoice = rand.nextInt(3) + 1;
            System.out.println("The computer chose: " + getChoice(cmpChoice));

            if (playerChoice == cmpChoice) {
                System.out.println("Draw you both chose " + getChoice(playerChoice));
                draws++;
            }
            else if (playerChoice == 1) {
                if (cmpChoice == 2) {
                    System.out.println("The computer wins");
                    cmpWins++;
                } else {
                    System.out.println("You win !");
                    playerWins++;
                }
            }
            else if (playerChoice == 2) {
                if (cmpChoice == 3) {
                    System.out.println("The computer wins");
                    cmpWins++;
                } else {
                    System.out.println("You win !");
                    playerWins++;
                }
            }
            else {
                if (cmpChoice == 1) {
                    System.out.println("The computer wins");
                    cmpWins++;
                } else {
                    System.out.println("You win !");
                    playerWins++;
                }
            }

        }

        return new int[] {playerWins, cmpWins, draws};
    }

    private static String getChoice(int choice) {
        switch (choice) {
            case 1:  return "Rock";
            case 2:  return "Paper";
            case 3:  return "Scissors";
            default: return "Invalid month";
        }
    }
}
