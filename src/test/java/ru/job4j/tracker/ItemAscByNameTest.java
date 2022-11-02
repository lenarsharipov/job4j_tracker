package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compareItemsAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "ccc"),
                new Item(2, "aaa"),
                new Item(3, "bbb")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "aaa"),
                new Item(3, "bbb"),
                new Item(1, "ccc")
        );
        assertEquals(expected, items);
    }

}