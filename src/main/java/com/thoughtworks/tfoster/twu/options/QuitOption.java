package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.ApplicationDriver;

public class QuitOption implements MenuOption {
    private ApplicationDriver driver;

    public QuitOption(ApplicationDriver driver) {
        this.driver = driver;
    }

    @Override
    public String title() {
        return "Quit";
    }

    @Override
    public void run() {
        driver.quit();
    }
}
