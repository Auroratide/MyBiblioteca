package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.*;
import com.thoughtworks.tfoster.twu.util.BookCollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ApplicationDriver driver = new ApplicationDriver();

        Library library = initializeLibrary(printStream);
        ArrayList<MenuOption> options = initializeOptions(printStream, reader, library, driver);


        MainMenu mainMenu = new MainMenu(printStream, reader, options);
        Biblioteca biblioteca = new Biblioteca(driver, printStream, mainMenu);

        biblioteca.start();
    }

    private static ArrayList<MenuOption> initializeOptions(PrintStream printStream, BufferedReader reader, Library library, ApplicationDriver driver) {
        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new PrintLibraryOption(library));
        options.add(new CheckoutBookOption(library, printStream, reader));
        options.add(new ReturnBookOption(library, printStream, reader));
        options.add(new QuitOption(driver));
        return options;
    }

    private static Library initializeLibrary(PrintStream printStream) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Proton", "Author 1", "2001", printStream));
        books.add(new Book("Electron", "Author 2", "2002", printStream));
        books.add(new Book("Neutron", "Author 3", "2003", printStream));

        Collection<Book> checkedOutBooks = new ArrayList<>();

        return new Library(new BookCollection(books), new BookCollection(checkedOutBooks));
    }


}
