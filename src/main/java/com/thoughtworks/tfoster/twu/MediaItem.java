package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.util.FormattingUtility;

import java.io.PrintStream;

public class MediaItem {
    private static final int TITLE_WIDTH = 15;

    private String title;
    private PrintStream printStream;
    private MediaItemDetails mediaItemDetails;

    public MediaItem(String title, PrintStream printStream, MediaItemDetails mediaItemDetails) {
        this.title = title;
        this.printStream = printStream;
        this.mediaItemDetails = mediaItemDetails;
    }

    public boolean hasTitle(String title) {
        return this.title.equals(title);
    }

    public void print() {
        printStream.print(FormattingUtility.fixFieldWidth(title, TITLE_WIDTH));
        printStream.print(" | ");
        printStream.print(mediaItemDetails.format());
    }
}