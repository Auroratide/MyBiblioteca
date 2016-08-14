package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieTest {

    private PrintStream printStream;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        movie = new Movie("Title", "Director", "2016", "10", printStream);
    }

    @Test
    public void shouldSeeTitleDirectorYearAndRatingWhenPrinted() {
        movie.print();

        verify(printStream).print("          Title");
        verify(printStream).print("       Director");
        verify(printStream).print("2016");
        verify(printStream).print("10");
    }
}