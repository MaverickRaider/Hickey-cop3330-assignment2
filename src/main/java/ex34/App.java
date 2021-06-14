
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex34;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] employeeList = employeeListMaker();

        printArr(employeeList);

        System.out.println();
        System.out.print("Enter an employee name to remove: ");
        System.out.println();

        String target = scanIn();

        String[] newEmployeeList = removeEmployee(employeeList, target);

        printArr(newEmployeeList);
    }

    public static String[] removeEmployee(String[] array,  String removal) {
        // -1 is used as a tracker to ensure the name given is on the list.
        int indexMark = -1;

        // if the name is found on the list, indexMaker is changed and used to delete the element.
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(removal)) {
                indexMark = i;
                break;
            }
        }

        // if indexMarker is still -1, then the system knows the name is not on the list and returns the same list.
        if (indexMark == -1) {
            System.out.println("Employee not found.");
            System.out.println();
            return array;
        }

        // Copies the array to another array and skips over the target employee we are trying to remove.
        String[] copyList = new String[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == indexMark) {
                copyList[j++] = array[i];
            }
        }
        return copyList;
    }

    public static void printArr(String[] strArr) {
        System.out.println("There are " + strArr.length + " employees:");
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
    }

    public static String scanIn() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String[] employeeListMaker() {
        String[] strArray = new String[5];

        strArray[0] = "John Smith";
        strArray[1] = "Jackie Jackson";
        strArray[2] = "Chris Jones";
        strArray[3] = "Amanda Cullen";
        strArray[4] = "Jeremy Goodwin";

        return strArray;
    }
}
