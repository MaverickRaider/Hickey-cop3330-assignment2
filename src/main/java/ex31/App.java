
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex31;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Enter your Resting Pulse: ");
        int restingPulse = intValidCheck();
        System.out.print("Enter your Age: ");
        int age = intValidCheck();

        karvonenHeartRate(restingPulse, age);
    }

    public static void karvonenHeartRate(int restingPulse, int age) {
        double intensity = 55;

        System.out.println();
        System.out.println("Resting Pulse: " + restingPulse + "     Age: " + age);
        System.out.println();
        System.out.println("Intensity   | Rate");
        System.out.println("------------|--------");

        for (int i = 0; i <= 8; i++) {
            double targetHeartRate = (((220 - age) - restingPulse) * (intensity/100)) + restingPulse;
            int intTargetHeartRate = (int)Math.ceil(targetHeartRate);
            System.out.println(intensity + "%       | " + intTargetHeartRate + " bpm");
            intensity = intensity + 5;
        }
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int intValidCheck() {
        int val = 0;
        String input;

        do {
            input = scanIn();

            if(!letterChecker(input)){
                val = Integer.parseInt(input);

                if (val < 0) {
                    System.out.println("Sorry. That's not a valid input.");
                }
            }

            if (letterChecker(input))
                System.out.println("Sorry. That's not a valid input.");
        }
        while (letterChecker(input) || val < 0);

        return val;
    }

    public static boolean letterChecker(String str) {
        boolean isInvalid = false;
        char[] strCheck = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(strCheck[i])) {
                isInvalid = true;
            }
        }
        return isInvalid;
    }
}
