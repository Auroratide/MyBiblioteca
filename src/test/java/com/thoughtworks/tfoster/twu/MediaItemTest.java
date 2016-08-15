package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MediaItemTest {

    private MediaItem mediaItem;
    private PrintStream printStream;
    private MediaItemDetails mediaItemDetails;
    private String title;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        mediaItemDetails = mock(MediaItemDetails.class);
        title = "Expected Title";
        mediaItem = new MediaItem(title, printStream, mediaItemDetails);
    }

    @Test
    public void shouldReturnTrueWhenTitleMatches() throws Exception {
        assertTrue(mediaItem.hasTitle(title));
    }

    @Test
    public void shouldReturnFalseWhenTitleDoesntMatch() throws Exception {
        assertFalse(mediaItem.hasTitle("Other Title"));
    }

    @Test
    public void shouldPrintDetailsWhenPrinted() throws Exception {
        mediaItem.print();

        verify(mediaItemDetails).format();
    }

    @Test
    public void shouldPrintTitleWhenPrinted() throws Exception {
        mediaItem.print();

        verify(printStream).print(" " + title); // because fixFieldWidth is not tested
    }
}