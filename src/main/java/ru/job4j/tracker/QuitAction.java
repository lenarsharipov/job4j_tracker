package ru.job4j.tracker;

public class QuitAction implements UserAction {
    private final Output out;

    public QuitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Quit the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }

}
