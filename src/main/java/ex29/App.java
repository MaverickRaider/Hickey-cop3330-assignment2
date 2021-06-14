
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex29;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int years = calc();
        System.out.println("It will take " + years + " years to double your initial investment.");
    }

    public static String scanInVal() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static boolean letterChecker(String str) {
        boolean invalid = false;
        char[] strCheck = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(strCheck[i])) {
                invalid = true;
            }
        }
        return invalid;
    }

    public static int calc() {
        int ans = 0, rate = 0;
        String input = "";
        do {
            System.out.println("What is the rate of return?");
            input = scanInVal();

            if(!letterChecker(input)){
                rate = Integer.parseInt(input);
            }

            if (rate == 0 || letterChecker(input))
                System.out.println("Sorry. That's not a valid input.");
        }
        while (rate == 0 || letterChecker(input));

        ans = 72 / rate;

        return ans;
    }
}
