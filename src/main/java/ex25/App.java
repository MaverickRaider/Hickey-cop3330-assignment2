
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex25;
import java.util.Scanner;

public class App {
    // Main Function
    public static void main(String[] args) {
        System.out.println("Welcome to Password Strength Indicator");
        System.out.println("Enter a password:");
        String s1 = scanIn();
        int val = passwordValidator(s1);
        String response = responseMaker(val);
        System.out.println(s1 + " is a " + response + " password");
    }

    // Scanner Method, taking in from console.
    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    public static int passwordValidator(String password) {
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = password.toCharArray();

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(Password[i]))
                uppercase = 1;

            if (Character.isLowerCase(Password[i]))
                lowercase = 1;

            if (Character.isDigit(Password[i]))
                digits = 1;
        }

        if (password.contains("~") || password.contains("!") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&") || password.contains("*")) {
            specialcharacters = 1;
        }
        if (password.length() < 8 && digits == 1&& (uppercase == 0 || lowercase == 0))
            return 0;
        else if (password.length() < 8 && (uppercase == 1 || lowercase == 1) && digits == 0 && specialcharacters == 0)
            return 1;
        else if (password.length() >= 8 && (uppercase == 1 || lowercase == 1) && digits == 1 && specialcharacters == 0)
            return 2;
        else if (password.length() >= 8 && (uppercase == 1 || lowercase == 1) && digits == 1 && specialcharacters == 1)
            return 3;
        else
            return 0;
    }

    public static String responseMaker(int val) {
        String answer = "";
        switch(val) {
            case 0:
                answer = "very weak";
                break;
            case 1:
                answer = "weak";
                break;
            case 2:
                answer = "strong";
                break;
            case 3:
                answer = "very strong";
                break;
            default:
                answer = "ERROR";
                break;
        }
        return answer;
    }
}