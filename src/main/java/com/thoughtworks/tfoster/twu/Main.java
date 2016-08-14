package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.*;
import com.thoughtworks.tfoster.twu.util.MediaCollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ApplicationDriver driver = new ApplicationDriver();

        MediaDatabase bookDatabase = initializeLibrary(printStream);
        MediaDatabase movieDatabase = initializeMovies(printStream);
        ArrayList<MenuOption> options = initializeOptions(printStream, reader, bookDatabase, movieDatabase, driver);

        MainMenu mainMenu = new MainMenu(printStream, reader, options);
        Biblioteca biblioteca = new Biblioteca(driver, printStream, mainMenu);

        biblioteca.start();
    }

    private static ArrayList<MenuOption> initializeOptions(PrintStream printStream, BufferedReader reader, MediaDatabase bookDatabase, MediaDatabase movieDatabase, ApplicationDriver driver) {
        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new PrintMediaDatabaseOption(bookDatabase));
        options.add(new PrintMediaDatabaseOption(movieDatabase));
        options.add(new CheckoutMediaItemOption(bookDatabase, printStream, reader));
        options.add(new CheckoutMediaItemOption(movieDatabase, printStream, reader));
        options.add(new ReturnMediaItemOption(bookDatabase, printStream, reader));
        options.add(new ReturnMediaItemOption(movieDatabase, printStream, reader));
        options.add(new QuitOption(driver));
        return options;
    }

    private static MediaDatabase initializeLibrary(PrintStream printStream) {
        List<MediaItem> books = new ArrayList<>();
        books.add(new Book("Proton", "Author 1", "2001", printStream));
        books.add(new Book("Electron", "Author 2", "2002", printStream));
        books.add(new Book("Neutron", "Author 3", "2003", printStream));

        Collection<MediaItem> checkedOutBooks = new ArrayList<>();

        return new MediaDatabase(new MediaCollection(books), new MediaCollection(checkedOutBooks));
    }

    private static MediaDatabase initializeMovies(PrintStream printStream) {
        List<MediaItem> movies = new ArrayList<>();
        movies.add(new Movie("Mercury", "Director 1", "1999", "7", printStream));
        movies.add(new Movie("Venus", "Director 2", "1998", "5", printStream));
        movies.add(new Movie("Earth", "Director 3", "1997", "10", printStream));

        Collection<MediaItem> checkedOutMovies = new ArrayList<>();

        return new MediaDatabase(new MediaCollection(movies), new MediaCollection(checkedOutMovies));
    }

}
