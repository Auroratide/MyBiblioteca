package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnMediaItemOptionTest {

    private MediaDatabase mediaDatabase;
    private BufferedReader reader;
    private ReturnMediaItemOption option;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        mediaDatabase = mock(MediaDatabase.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        option = new ReturnMediaItemOption(mediaDatabase, printStream, reader);
    }

    @Test
    public void shouldInformUserOfPromptWhenRun() throws Exception {
        option.run();

        verify(printStream).println("Type in the title of the book you want to return:");
    }

    @Test
    public void shouldPromptUserForBookTitleWhenRun() throws Exception {
        option.run();

        verify(reader).readLine();
    }

    @Test
    public void shouldReturnSpecifiedBookWhenRun() throws Exception {
        String title = "Title";
        when(reader.readLine()).thenReturn(title);
        when(mediaDatabase.isCheckedOut(title)).thenReturn(true);
        option.run();

        verify(mediaDatabase).returnItem(title);
    }

    @Test
    public void shouldCheckIfBookWithTitleIsCheckedOutWhenRun() throws Exception {
        String title = "Book Title";
        when(reader.readLine()).thenReturn(title);
        option.run();

        verify(mediaDatabase).isCheckedOut(title);
    }

    @Test
    public void shouldPrintSuccessMessageIfBookHasBeenReturned() throws Exception {
        String bookTitle = "Title of Book";
        when(reader.readLine()).thenReturn(bookTitle);
        when(mediaDatabase.isCheckedOut(bookTitle)).thenReturn(true);
        option.run();

        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldPrintErrorMessageIfBookIsNotCheckedOut() throws Exception {
        String bookTitle = "Title of Book";
        when(reader.readLine()).thenReturn(bookTitle);
        when(mediaDatabase.isAvailable(bookTitle)).thenReturn(false);
        option.run();

        verify(printStream).println("That is not a valid book to return.");
    }
}