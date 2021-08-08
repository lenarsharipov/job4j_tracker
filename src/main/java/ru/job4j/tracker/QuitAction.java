package ru.job4j.tracker;

public class QuitAction implements UserAction {
    @Override
    public String name() {
        return "Quit the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
