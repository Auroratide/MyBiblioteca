package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.ApplicationDriver;
import com.thoughtworks.tfoster.twu.Biblioteca;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitOptionTest {
    @Test
    public void shouldQuitBibliotecaWhenRun() throws Exception {
        ApplicationDriver driver = mock(ApplicationDriver.class);
        QuitOption quitOption = new QuitOption(driver);
        quitOption.run();

        verify(driver).quit();
    }
}