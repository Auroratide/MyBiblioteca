package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.MenuOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private List<MenuOption> options;

    public MainMenu(PrintStream printStream, BufferedReader reader, List<MenuOption> options) {
        this.printStream = printStream;
        this.reader = reader;
        this.options = options;
    }

    public void showMenu() {
        int currentItem = 1;
        for(MenuOption option : options) {
            printStream.print(currentItem + ": ");
            printStream.print(option.title());
            printStream.print("\n");
            ++currentItem;
        }
    }

    public void processUserSelection() {
        printStream.print("\n> ");

        try {
            String userInput = reader.readLine();

            if(isValidMenuSelection(userInput))
                options.get(Integer.parseInt(userInput) - 1).run();
            else
                printStream.println("Select a valid option!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidMenuSelection(String selection) {
        if(selection.matches("\\d+")) {
            int numericSelection = Integer.parseInt(selection);
            return 0 < numericSelection && numericSelection <= options.size();
        }
        else
            return false;
    }
}
