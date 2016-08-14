package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CheckoutMediaItemOptionTest {

    private PrintStream printStream;
    private CheckoutMediaItemOption option;
    private BufferedReader bufferedReader;
    private MediaDatabase mediaDatabase;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        mediaDatabase = mock(MediaDatabase.class);
        option = new CheckoutMediaItemOption(mediaDatabase, printStream, bufferedReader);
    }

    @Test
    public void shouldInformUserOfPromptForBookTitleWhenRun() throws Exception {
        option.run();

        verify(printStream).println("Type in the title of the book you want to check out:");
    }

    @Test
    public void shouldPromptUserForBookTitleWhenRun() throws Exception {
        option.run();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldCheckoutSpecifiedBookFromLibraryWhenRun() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(mediaDatabase.isAvailable(bookTitle)).thenReturn(true);
        option.run();

        verify(mediaDatabase).checkoutItem(bookTitle);
    }

    @Test
    public void shouldCheckIfBookWithTitleIsAvailableWhenRun() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        option.run();

        verify(mediaDatabase).isAvailable(bookTitle);
    }

    @Test
    public void shouldPrintSuccessMessageIfBookHasBeenCheckedOut() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(mediaDatabase.isAvailable(bookTitle)).thenReturn(true);
        option.run();

        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldPrintErrorMessageIfBookIsNotAvailable() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(mediaDatabase.isAvailable(bookTitle)).thenReturn(false);
        option.run();

        verify(printStream).println("That book is not available.");
    }
}