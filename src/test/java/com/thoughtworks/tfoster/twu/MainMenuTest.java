package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.MenuOption;
import com.thoughtworks.tfoster.twu.options.PrintMediaDatabaseOption;
import com.thoughtworks.tfoster.twu.options.QuitOption;
import com.thoughtworks.tfoster.twu.options.ReturnMediaItemOption;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private ArrayList<MenuOption> options;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);

        options = new ArrayList<>();
        options.add(mock(MenuOption.class));
        options.add(mock(MenuOption.class));
        reader = mock(BufferedReader.class);

        mainMenu = new MainMenu(printStream, reader, options);
    }

    @Test
    public void shouldSeeListBooksWhenListingBooksIsAnOption() throws Exception {
        PrintMediaDatabaseOption printMediaDatabaseOption = mock(PrintMediaDatabaseOption.class);
        when(printMediaDatabaseOption.title()).thenCallRealMethod();
        options.add(printMediaDatabaseOption);
        mainMenu.showMenu();

        verify(printStream).print("List Books");
    }

    @Test
    public void shouldSeeQuitWhenQuittingIsAnOption() throws Exception {
        QuitOption quitOption = mock(QuitOption.class);
        when(quitOption.title()).thenCallRealMethod();
        options.add(quitOption);
        mainMenu.showMenu();

        verify(printStream).print("Quit");
    }

    @Test
    public void shouldSeeReturnBooksWhenReturningIsAnOption() throws Exception {
        ReturnMediaItemOption returnMediaItemOption = mock(ReturnMediaItemOption.class);
        when(returnMediaItemOption.title()).thenCallRealMethod();
        options.add(returnMediaItemOption);
        mainMenu.showMenu();

        verify(printStream).print("Return book");
    }

    @Test
    public void shouldSeeBothListBooksAndQuitWhenBothListingBooksAndQuittingAreOptions() throws Exception {
        PrintMediaDatabaseOption printMediaDatabaseOption = mock(PrintMediaDatabaseOption.class);
        when(printMediaDatabaseOption.title()).thenCallRealMethod();
        QuitOption quitOption = mock(QuitOption.class);
        when(quitOption.title()).thenCallRealMethod();

        options.add(printMediaDatabaseOption);
        options.add(quitOption);
        mainMenu.showMenu();

        verify(printStream).print("List Books");
        verify(printStream).print("Quit");
    }

    @Test
    public void shouldRunSecondOptionWhenOption2IsChosen() throws Exception {
        options.add(mock(MenuOption.class));
        options.add(mock(MenuOption.class));
        options.add(mock(MenuOption.class));

        when(reader.readLine()).thenReturn("2");
        mainMenu.processUserSelection();
        verify(options.get(1)).run();
    }

    @Test
    public void shouldPrintBooksWhenOption1IsChosen() throws Exception {
        options.add(mock(MenuOption.class));
        options.add(mock(MenuOption.class));
        options.add(mock(MenuOption.class));
        when(reader.readLine()).thenReturn("1");

        mainMenu.processUserSelection();

        verify(options.get(0)).run();
    }

    @Test
    public void shouldInformUserToSelectValidOptionWhenNonnumericSelected() throws Exception {
        when(reader.readLine()).thenReturn("*");

        mainMenu.processUserSelection();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldInformUserToSelectValidOptionWhenInvalidNumberSelected() throws Exception {
        when(reader.readLine()).thenReturn("-1");

        mainMenu.processUserSelection();

        verify(printStream).println("Select a valid option!");
    }

}