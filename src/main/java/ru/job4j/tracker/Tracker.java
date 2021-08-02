package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item val = items[index];
            if (val != null && val.getName().equals(key)) {
                tmp[size] = val;
                size++;
            }
        }
        return Arrays.copyOf(tmp, size);
    }

    public Item[] findAll() {
        Item[] tmp = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item val = items[index];
            if (val != null) {
                tmp[size] = val;
                size++;
            }
        }
        return Arrays.copyOf(tmp, size);
    }
}