
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

//NOT DONE YET

package ex26;
import java.util.Scanner;
import java.lang.Math;

public class App {
    // Main Function
    public static void main(String[] args) {
        System.out.println("What is your balance?");
        int balance = scanInNum();
        System.out.println("What is the APR on the card (as a percent)?");
        int apr = scanInNum();
        System.out.println("What is the monthly payment you can make?");
        int monthlyPayment = scanInNum();

        double numMonths = paymentCalculator(balance, apr, monthlyPayment);

        System.out.println("It will take you " + numMonths + " months to pay off this card.");
    }

    // Scanner Method, taking in from console.
    public static int scanInNum() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static double paymentCalculator(double balance, double apr, double monthlyPayments) {
        double n;
        double dailyArp = (apr / 100) / 365;
        double x1 = Math.log(1 + dailyArp);
        double x2 = (1 - Math.pow((1 + dailyArp),30));
        double x3 = 1 + balance / monthlyPayments;
        double x4 = Math.log(x3 * x2 / x1);
        n = -((double)1/30) * x4;
        return n;
    }
}