
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex28;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int ans = calc();
        System.out.println("The total is " + ans + ".");
    }

    public static int scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int calc() {
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number:");
            int input = scanIn();
            ans = ans + input;
        }
        return ans;
    }
}
