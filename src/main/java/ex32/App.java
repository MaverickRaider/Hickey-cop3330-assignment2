
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex32;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Let's play Guess the Number!");
        System.out.println("");
        System.out.print("Enter the difficulty level (1, 2, or 3): ");

        // Starting Bounds for checking difficulty
        int difficulty = validCheck(3);
        guessNumGame(difficulty);
    }

    public static void guessNumGame(int difficulty){
        int bound = setDifficulty(difficulty);
        int ranNum = randomNumGen(bound);
        int guess = 0;
        int counter = 0;

        System.out.print("I have my number. What's your guess?: ");

        do {
            guess = validCheck(bound);
            counter++;

            if (guess < ranNum) {
                System.out.print("Too low, Guess again: ");
            }
            if (guess > ranNum) {
                System.out.print("Too high, Guess again: ");
            }
            if (guess == ranNum) {
                System.out.println("You got it in " + counter + " guesses!");
                if (counter == 1) {
                    System.out.print("You’re a mind reader!");
                }
                if (counter >= 2 && counter <= 4) {
                    System.out.print("Most impressive.");
                }
                if (counter >= 5 && counter <= 6 ) {
                    System.out.print("You can do better than that.");
                }
                if (counter >= 7) {
                    System.out.print("Better luck next time.");
                }
            }
        }
        while (guess != ranNum);
    }

    public static int randomNumGen(int bound) {
        Random random = new Random();
        int number = random.nextInt(bound);
        return number + 1;
    }

    public static int setDifficulty(int diff) {
        int bounds = 0;
        switch (diff) {
            case 1:
                bounds =  10;
                break;
            case 2:
                bounds =  100;
                break;
            case 3:
                bounds =  1000;
                break;
            default:
                System.out.print("Error!");
                System.exit(0);
        }
        return bounds;
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int validCheck(int bounds) {
        int val = 0;
        String input;

        do {
            input = scanIn();

            if(!digitChecker(input)){
                val = Integer.parseInt(input);

                if (val < 1 || val > bounds + 1) {
                    System.out.println("Sorry. That's not a valid Difficulty.");
                }
            }

            if (digitChecker(input))
                System.out.println("Sorry. That's not a valid Difficulty.");
        }
        while (digitChecker(input) || val < 1 || val > bounds + 1);

        return val;
    }

    public static boolean digitChecker(String str) {
        boolean isDigit = false;
        char[] strCheck = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(strCheck[i])) {
                isDigit = true;
            }
        }
        return isDigit;
    }
}

