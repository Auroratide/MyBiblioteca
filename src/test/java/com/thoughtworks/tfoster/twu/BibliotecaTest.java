package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private MainMenu mainMenu;
    private ApplicationDriver driver;

    private void quitAfterRuns(int number) {
        OngoingStubbing stub = when(driver.isRunning());
        for(int i = 0; i < number; ++i)
            stub = stub.thenReturn(true);
        stub.thenReturn(false);
    }

    @Before
    public void setUp() throws Exception {
        driver = mock(ApplicationDriver.class);
        printStream = mock(PrintStream.class);
        mainMenu = mock(MainMenu.class);

        biblioteca = new Biblioteca(driver, printStream, mainMenu);
    }

    @Test
    public void shouldSeeWelcomeMessageWhenStarted() throws Exception {
        quitAfterRuns(1);
        biblioteca.start();

        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldStartMenuWhenStarted() throws Exception {
        quitAfterRuns(1);
        biblioteca.start();

        verify(mainMenu).showMenu();
    }

    @Test
    public void shouldStartDriverWhenStarted() throws Exception {
        biblioteca.start();

        verify(driver).start();
    }

    @Test
    public void shouldLetUserSelectFromOptionsWhenStarted() throws Exception {
        quitAfterRuns(1);
        biblioteca.start();

        verify(mainMenu).processUserSelection();
    }

    @Test
    public void shouldContinueAskingForUserSelectionUntilQuit() throws Exception {
        quitAfterRuns(3);
        biblioteca.start();

        verify(mainMenu, times(3)).processUserSelection();
    }
}