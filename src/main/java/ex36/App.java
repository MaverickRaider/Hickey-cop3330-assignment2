
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex36;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        takeInput();
    }
    public static void calculateMath(int[] arr) {
        System.out.println("The average is: " + average(arr));
        System.out.println("The max is: " + max(arr));
        System.out.println("The min is: " + min(arr));
        System.out.println("The standard deviation is: " + std(arr));
    }
    public static double average(int[] arr) {
        int add = 0;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            add = add + arr[i];
        }
        answer = add / arr.length;
        return answer;
    }
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
    public static double std(int[] arr) {
        double sum = 0, sd = 0;

        for(double num : arr) {
            sum += num;
        }
        double mean = sum / arr.length;

        for(double num: arr) {
            sd += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sd / arr.length);
    }

    public static void takeInput() {
        String str;
        int[] arr = new int[0];
        while (true) {
            System.out.print("Enter a number: ");
            str = scanIn();
            str = str.toLowerCase();
            if (str.equals("done")) {
                calculateMath(arr);
                break;
            }
            if(digitChecker(str)){
                arr = addTo(arr.length, arr, Integer.parseInt(str));
            }
            else {
                System.out.println("Invalid input! Expected digits.");
            }
        }
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

    public static int[] addTo(int n, int[] arr, int input)
    {
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = input;
        return newArr;
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
