package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compareItemsDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "aaa"),
                new Item(2, "ccc"),
                new Item(3, "bbb")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "ccc"),
                new Item(3, "bbb"),
                new Item(1, "aaa")
        );
        assertEquals(expected, items);
    }
}