package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.util.MediaCollection;

public class MediaDatabase {

    private String mediaType;
    private MediaCollection availableItems;
    private MediaCollection checkedOutItems;

    public MediaDatabase(String mediaType, MediaCollection availableItems, MediaCollection checkedOutItems) {
        this.mediaType = mediaType;
        this.availableItems = availableItems;
        this.checkedOutItems = checkedOutItems;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void print() {
        for(MediaItem item : availableItems)
            item.print();
    }

    public void checkoutItem(String title) {
        availableItems.moveToCollection(title, checkedOutItems);
    }

    public void returnItem(String title) {
        checkedOutItems.moveToCollection(title, availableItems);
    }

    public boolean isAvailable(String title) {
        return availableItems.contains(title);
    }

    public boolean isCheckedOut(String title) {
        return checkedOutItems.contains(title);
    }

}
