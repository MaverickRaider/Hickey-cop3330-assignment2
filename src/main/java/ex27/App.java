
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex27;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Enter the first name:");
        String fName = scanIn();
        System.out.println("Enter the last name:");
        String lName = scanIn();
        System.out.println("Enter the ZIP code:");
        String zip = scanIn();
        System.out.println("Enter the employee ID:");
        String id = scanIn();

        if (validateInput(fName, lName, zip, id)) {
            System.out.println("There were no errors found.");
        }
    }

    // Scanner Method, taking in from console.
    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static boolean validateInput(String fName, String lName, String zip, String id) {
        if (id.length() < 7)
            id = "ERROR-1";
        char[] idArray = id.toCharArray();
        char[] zipArray = zip.toCharArray();

        boolean letter = false;
        boolean digits = false;
        boolean zipPass = true;
        int count = 0;

        boolean pass = true;

        if (Character.isUpperCase(idArray[0]) && Character.isUpperCase(idArray[1]))
            letter = true;
        for (int i = 3; i < id.length(); i ++) {
            if (Character.isDigit(idArray[i]))
                count++;
        }
        if (count == 5)
            digits = true;

        for (int i = 0; i < zip.length(); i ++) {
            if (!Character.isDigit(zipArray[i])) {
                zipPass = false;
                break;
            }
        }

        if (fName.length() < 3) {
            System.out.println("The first name must be at least 2 characters long.");
            pass = false;
        }
        if (fName.equals("")) {
            System.out.println("The first name must be filled in.");
            pass = false;
        }
        if (lName.length() < 3) {
            System.out.println("The last name must be at least 2 characters long.");
            pass = false;
        }
        if (lName.equals("")) {
            System.out.println("The last name must be filled in.");
            pass = false;
        }
        if (!letter || !digits) {
            System.out.println("The employee ID must be in the format of AA-1234.");
            pass = false;
        }
        if (zip.length() != 5 || !zipPass) {
            System.out.println("The zipcode must be a 5 digit number.");
            pass = false;
        }

        return pass;
    }
}