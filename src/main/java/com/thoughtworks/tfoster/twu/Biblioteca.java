package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class Biblioteca {

    private ApplicationDriver driver;
    private PrintStream printStream;
    private MainMenu mainMenu;

    public Biblioteca(ApplicationDriver driver, PrintStream printStream, MainMenu mainMenu) {
        this.driver = driver;
        this.printStream = printStream;
        this.mainMenu = mainMenu;
    }

    public void start() {
        driver.start();
        printStream.println("Welcome!");

        while(driver.isRunning()) {
            mainMenu.showMenu();
            mainMenu.processUserSelection();
        }
    }

}
