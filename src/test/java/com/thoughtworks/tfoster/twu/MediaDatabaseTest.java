package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.util.MediaCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class MediaDatabaseTest {

    private MediaCollection availableItems;
    private MediaCollection checkedOutItems;
    private MediaDatabase mediaDatabase;

    @Before
    public void setUp() throws Exception {
        availableItems = mock(MediaCollection.class);
        checkedOutItems = mock(MediaCollection.class);

        mediaDatabase = new MediaDatabase(availableItems, checkedOutItems);
    }

    @Test
    public void shouldConsultAvailableBooksWhenCheckingIfABookIsAvailable() throws Exception {
        mediaDatabase.isAvailable("Title");

        verify(availableItems).contains("Title");
    }

    @Test
    public void shouldConsultCheckedOutBooksWhenCheckingIfABookIsCheckedOut() throws Exception {
        mediaDatabase.isCheckedOut("Title");

        verify(checkedOutItems).contains("Title");
    }

    @Test
    public void shouldMoveBookToCheckedOutBooksWhenCheckingOutABook() throws Exception {
        mediaDatabase.checkoutItem("Title");

        verify(availableItems).moveToCollection("Title", checkedOutItems);
    }

    @Test
    public void shouldMoveBookToAvailableBooksWhenReturningABook() throws Exception {
        mediaDatabase.returnItem("Title");

        verify(checkedOutItems).moveToCollection("Title", availableItems);
    }

    @Test
    public void shouldPrintAvailableBooksWhenPrinted() throws Exception {
        MediaItem item1 = mock(MediaItem.class);
        MediaItem item2 = mock(MediaItem.class);
        MediaItem item3 = mock(MediaItem.class);
        Collection<MediaItem> availableBackend = new ArrayList<>();
        availableBackend.add(item1);
        availableBackend.add(item2);
        Collection<MediaItem> checkedOutBackend = new ArrayList<>();
        checkedOutBackend.add(item3);

        mediaDatabase = new MediaDatabase(new MediaCollection(availableBackend), new MediaCollection(checkedOutBackend));
        mediaDatabase.print();

        verify(item1).print();
        verify(item2).print();
        verify(item3, never()).print();
    }

}