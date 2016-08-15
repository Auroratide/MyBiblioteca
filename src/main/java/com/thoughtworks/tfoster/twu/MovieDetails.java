package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

import static com.thoughtworks.tfoster.twu.util.FormattingUtility.fixFieldWidth;

public class MovieDetails implements MediaItemDetails {

    private static final int DIRECTOR_WIDTH = 15;

    private final String director;
    private final String year;
    private final String rating;
    private PrintStream printStream;

    public MovieDetails(String director, String year, String rating) {
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.printStream = printStream;
    }

    @Override
    public String format() {
        String formattedString = fixFieldWidth(director, DIRECTOR_WIDTH) + " | ";
        formattedString += fixFieldWidth(year, 4) + " | ";
        formattedString += fixFieldWidth(rating, 2) + "\n";
        return formattedString;
    }
}