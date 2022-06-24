package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        //return index != -1 ? items[index] : null;
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item val : items) {
            if (key.equals(val.getName())) {
                temp.add(val);
            }
        }
        return temp;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item val : items) {
            if (val.getId() == id) {
                rsl = val.getId() - 1;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return index != -1;
    }

}