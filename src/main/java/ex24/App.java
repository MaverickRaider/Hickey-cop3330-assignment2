
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex24;
import java.util.Scanner;
import java.util.Arrays;

public class App {
    // Main Function
    public static void main(String[] args) {
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.println("Enter the first string:");
        String s1 = scanIn();
        System.out.println("Enter the second string:");
        String s2 = scanIn();
        anagramCheck(s1, s2);
    }

    // Scanner Method, taking in from console.
    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    // Method for checking two strings that contain the same letters.
    public static void anagramCheck(String s1, String s2) {

        // Converts both strings into arrays to be sorted
        char[] str1 = stringToArray(s1);
        char[] str2 = stringToArray(s2);

        // Checks that both words are the same length
        int n1 = str1.length;
        int n2 = str2.length;
        if (n1 != n2) {
            System.out.println(s1 + " and " + s2 + " are not anagrams.");
            return;
        }

        // Sorts the arrays to be read easily
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Follows the array down the list until finding a letter that doesn't match.
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i]) {
                System.out.println(s1 + " and " + s2 + " are not anagrams.");
                return;
            }

        // If everything matches, they are an anagram.
        System.out.println(s1 + " and " + s2 + " are anagrams.");
        return;
    }

    // Converter for turning an inputted String into an Char Array
    public static char[] stringToArray(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
}