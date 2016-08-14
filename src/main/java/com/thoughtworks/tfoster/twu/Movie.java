package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class Movie implements MediaItem {

    private static final int TITLE_WIDTH = 15;
    private static final int DIRECTOR_WIDTH = 15;

    private final String title;
    private final String director;
    private final String year;
    private final String rating;
    private PrintStream printStream;

    public Movie(String title, String director, String year, String rating, PrintStream printStream) {

        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.printStream = printStream;
    }

    public void print() {
        printStream.print(fixFieldWidth(title, TITLE_WIDTH));
        printStream.print(" | ");
        printStream.print(fixFieldWidth(director, DIRECTOR_WIDTH));
        printStream.print(" | ");
        printStream.print(fixFieldWidth(year, 4));
        printStream.print(" | ");
        printStream.print(fixFieldWidth(rating, 2));
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
