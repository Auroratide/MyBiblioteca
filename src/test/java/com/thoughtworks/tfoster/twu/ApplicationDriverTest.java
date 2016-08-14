package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApplicationDriverTest {

    private ApplicationDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ApplicationDriver();
    }

    @Test
    public void shouldReturnTrueWhenStarted() throws Exception {
        driver.start();

        assertTrue(driver.isRunning());
    }

    @Test
    public void shouldReturnFalseWhenQuit() throws Exception {
        driver.quit();

        assertFalse(driver.isRunning());
    }
}