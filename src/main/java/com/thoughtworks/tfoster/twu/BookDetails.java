package com.thoughtworks.tfoster.twu;

import static com.thoughtworks.tfoster.twu.util.FormattingUtility.fixFieldWidth;

import java.io.PrintStream;

public class BookDetails implements MediaItemDetails {

    private static final int AUTHOR_WIDTH = 15;

    private String author;
    private String yearPublished;

    public BookDetails(String author, String yearPublished) {
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String format() {
        String formattedString = fixFieldWidth(author, AUTHOR_WIDTH) + " | ";
        formattedString += fixFieldWidth(yearPublished, 4) + "\n";
        return formattedString;
    }
}
