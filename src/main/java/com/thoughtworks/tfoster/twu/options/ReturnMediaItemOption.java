package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ReturnMediaItemOption implements MenuOption {

    private MediaDatabase mediaDatabase;
    private PrintStream printStream;
    private BufferedReader reader;

    public ReturnMediaItemOption(MediaDatabase mediaDatabase, PrintStream printStream, BufferedReader reader) {
        this.mediaDatabase = mediaDatabase;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public String title() {
        return "Return " + mediaDatabase.getMediaType();
    }

    @Override
    public void run() {
        printStream.println("Type in the title of the " + mediaDatabase.getMediaType() + " you want to return:");

        printStream.print("> ");
        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(mediaDatabase.isCheckedOut(userInput)) {
            mediaDatabase.returnItem(userInput);
            printStream.println("Thank you for returning the " + mediaDatabase.getMediaType() + ".");
        }
        else
            printStream.println("That is not a valid " + mediaDatabase.getMediaType() + " to return.");
    }
}
