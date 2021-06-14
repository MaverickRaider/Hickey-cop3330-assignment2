
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex33;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("What's your question?");
        scanIn();
        String[] eightBall = eightBallResponses();
        int size = eightBall.length;
        System.out.println(eightBall[randomNumGen(size)]);
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int randomNumGen(int arrSize) {
        Random random = new Random();
        return random.nextInt(arrSize);
    }

    public static String[] eightBallResponses() {
        String[] strArray = new String[3];
        strArray[0] = "Yes";
        strArray[1] = "No";
        strArray[2] = "Ask again later";
        return strArray;
    }
}
