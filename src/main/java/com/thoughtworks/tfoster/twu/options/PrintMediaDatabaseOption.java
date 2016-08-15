package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;

public class PrintMediaDatabaseOption implements MenuOption {

    private MediaDatabase mediaDatabase;

    public PrintMediaDatabaseOption(MediaDatabase mediaDatabase) {
        this.mediaDatabase = mediaDatabase;
    }

    @Override
    public String title() {
        return "List " + mediaDatabase.getMediaType() + "s";
    }

    @Override
    public void run() {
        mediaDatabase.print();
    }
}
