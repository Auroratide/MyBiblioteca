package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class Book implements MediaItem {

    private static final int TITLE_WIDTH = 15;
    private static final int AUTHOR_WIDTH = 15;

    private String title;
    private String author;
    private String yearPublished;
    private PrintStream printStream;

    public Book(String title, String author, String yearPublished, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
    }

    public void print() {
        printStream.print(fixFieldWidth(title, TITLE_WIDTH));
        printStream.print(" | ");
        printStream.print(fixFieldWidth(author, AUTHOR_WIDTH));
        printStream.print(" | ");
        printStream.print(fixFieldWidth(yearPublished, 4));
        printStream.print("\n");
    }

    public boolean hasTitle(String title) {
        return this.title.equals(title);
    }

    private String fixFieldWidth(String field, int width) {
        String maxedString = field.substring(0, Math.min(field.length(), width));

        return String.format("%1$" + width + "s", maxedString);
    }

}
