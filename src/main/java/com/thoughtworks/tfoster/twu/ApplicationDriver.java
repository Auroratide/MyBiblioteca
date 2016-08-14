package com.thoughtworks.tfoster.twu;

public class ApplicationDriver {

    private boolean running;

    public ApplicationDriver() {}

    public void start() {
        running = true;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
