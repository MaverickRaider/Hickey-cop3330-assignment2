
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex35;
import java.util.*;
import java.lang.*;

public class App {
    public static void main(String[] args) {

        pickAWinner();

    }

    public static void pickAWinner() {
        String inputName = "";
        String[] nameArr = new String[1];

        while (true) {
            System.out.print("Enter a name: ");
            inputName = scanIn();
            if (inputName.isEmpty()) {
                break;
            }
            nameArr = addTo(nameArr.length, nameArr, inputName);
        }

        int numUsers = nameArr.length - 1;
        int winner = randomNumGen(nameArr.length + 1);

        System.out.print("The winner is... " + nameArr[winner] + "!");
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int randomNumGen(int bound) {
        Random random = new Random();
        int number = random.nextInt(bound);
        return number + 1;
    }

    public static String[] addTo(int n, String[] arr, String addedName)
    {
        String[] newArr = new String[n + 1];

        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = addedName;

        return newArr;
    }
}
