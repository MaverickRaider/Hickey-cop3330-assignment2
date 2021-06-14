
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex30;

public class App {
    public static void main(String[] args) {
        int size = 12;
        multiplicationTable(size);
    }

    public static void multiplicationTable(int size) {
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                System.out.format("%4d", i * j);
            }
            System.out.println();
        }
    }
}
