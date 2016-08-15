package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookDetailsTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldSeeAuthorAndYearPublishedWhenPrinted() throws Exception {
        BookDetails book = new BookDetails("Author", "2001");
        assertThat(book.format(), is("         Author | 2001\n"));
    }

}