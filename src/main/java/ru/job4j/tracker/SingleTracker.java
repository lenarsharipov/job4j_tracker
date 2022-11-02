package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.util.List;

public class SingleTracker {
    private static SingleTracker uniqueInstance = null;
    private MemTracker memTracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingleTracker();
        }
        return uniqueInstance;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}