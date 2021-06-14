
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex38;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        System.out.print("Enter a list of numbers, separated by spaces: ");
        int[] filteredArray = filterValues();
        System.out.print("The even numbers are: ");
        for (int i = 0; i < filteredArray.length; i++) {
            System.out.print(filteredArray[i] + " ");
        }
    }

    public static int[] filterValues() {
        int[] arr = scanIn();
        int[] newArr = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
            {
                newArr = addTo(newArr.length, newArr, String.valueOf(arr[i]));
            }
        }
        return newArr;
    }

    public static int[] addTo(int n, int[] arr, String input)
    {
        int inputNum = 0;
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        if(digitChecker(input)){
            inputNum = Integer.parseInt(input);
        }
        newArr[n] = inputNum;
        return newArr;
    }

    public static int[] scanIn() {
        int[] arr = new int[0];
        Scanner in = new Scanner(System.in);
        Pattern digit = Pattern.compile("\\d");
        String nextInt = in.findInLine(digit);
        while (nextInt != null) {
            arr = addTo(arr.length, arr, nextInt);
            nextInt = in.findInLine(digit);
        }
        return arr;
    }

    public static boolean digitChecker(String str) {
        boolean isDigit = false;
        char[] strCheck = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(strCheck[i])) {
                isDigit = true;
            }
        }
        return isDigit;
    }
}
