package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutMediaItemOption implements MenuOption {

    private MediaDatabase mediaDatabase;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public CheckoutMediaItemOption(MediaDatabase mediaDatabase, PrintStream printStream, BufferedReader bufferedReader) {
        this.mediaDatabase = mediaDatabase;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String title() {
        return "Checkout book";
    }

    @Override
    public void run() {
        printStream.println("Type in the title of the book you want to check out:");

        printStream.print("> ");
        String title = readTitleFromUser();

        if(mediaDatabase.isAvailable(title)) {
            mediaDatabase.checkoutItem(title);
            printStream.println("Thank you! Enjoy the book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    private String readTitleFromUser() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
