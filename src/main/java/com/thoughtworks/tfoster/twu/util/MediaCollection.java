package com.thoughtworks.tfoster.twu.util;

import com.thoughtworks.tfoster.twu.MediaItem;

import java.util.Collection;
import java.util.Iterator;

public class MediaCollection implements Iterable<MediaItem> {

    private Collection<MediaItem> items;

    public MediaCollection(Collection<MediaItem> items) {
        this.items = items;
    }

    //  This is a smell; needs to be refactored
    @Override
    public Iterator<MediaItem> iterator() {
        return items.iterator();
    }

    public void moveToCollection(String title, MediaCollection other) {
        MediaItem item = getItemWithTitle(title);
        if(items.remove(item))
            other.items.add(item);
    }

    public boolean contains(String title) {
        return getItemWithTitle(title) != null;
    }

    private MediaItem getItemWithTitle(String title) {
        for(MediaItem item : items)
            if(item.hasTitle(title))
                return item;
        return null;
    }
}
