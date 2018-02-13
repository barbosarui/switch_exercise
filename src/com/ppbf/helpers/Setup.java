package com.ppbf.helpers;

import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Menu.printMenu;
import static com.ppbf.helpers.Menu.printSubMenu;

import com.ppbf.sandbox.Sandbox;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Setup {

    private static Scanner in = new Scanner(System.in);

    public static void startSandbox() throws FileNotFoundException {
        System.out.println("Welcome to the Switch Programme Exercise @Blip");

        boolean quit = false;

        do {
            printMenu();

            int menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    // readFromFile returns a List with each entry representing a line of the file.
                    List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                    System.out.print("Choose marketId:");
                    long marketId = in.nextLong();

                    Sandbox.ex1(lines, marketId);

                    break;
                case 2:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    Sandbox.ex2(lines);

                    break;
                case 3:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    BigDecimal TOTAL_CASH = new BigDecimal("30.1");
                    Map<String, BigDecimal> bets = new HashMap<>();

                    boolean exit = false;

                    do {
                        printSubMenu();

                        int selection = in.nextInt();

                        switch (selection) {
                            case 1:
                                bets = Sandbox.ex3_1(lines, TOTAL_CASH);
                                break;
                            case 2:
                                Sandbox.ex3_2(lines, bets);
                                break;
                            default:
                                exit = true;
                                break;
                        }
                    } while (!exit);

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
