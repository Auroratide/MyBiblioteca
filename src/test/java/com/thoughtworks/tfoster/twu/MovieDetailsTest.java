package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieDetailsTest {

    private MovieDetails movie;

    @Before
    public void setUp() {
        movie = new MovieDetails("Director", "2016", "10");
    }

    @Test
    public void shouldSeeDirectorYearAndRatingWhenFormatted() {
        assertThat(movie.format(), is("       Director | 2016 | 10\n"));
    }
}