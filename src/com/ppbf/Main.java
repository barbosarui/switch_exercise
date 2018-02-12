package com.ppbf;

import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Menu.printMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    //  throws clause vs try-catch block
    //  throws clause    - used to indicate that particular exception is possibly thrown from
    //                     executing method at run-time
    //  try-catch block  - used to handle exception scenario
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Welcome to the Switch Programme Exercise @Blip");

        boolean quit = false;

        do {
            printMenu();

            int menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    // readFromFile returns a List with each entry representing a line of the file.
                    List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    // ex1(lines);

                    break;
                case 2:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    // ex2(lines);

                    break;
                case 3:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    // ex3(lines);

                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);

        System.out.println("Bye-bye!");
    }
}
