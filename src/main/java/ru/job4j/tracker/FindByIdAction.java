package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by ID ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        return true;
    }
}
