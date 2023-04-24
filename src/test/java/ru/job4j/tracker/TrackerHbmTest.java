package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TrackerHbmTest {
    private final HbmTracker tracker = new HbmTracker();

    @AfterEach
    public void clear() {
        var items = tracker.findAll();
        for (var item : items) {
            tracker.delete(item.getId());
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplaceItemThenTrackerHasReplacedItem() {
        try {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item replaced = new Item();
            replaced.setName("test1Replaced");
            assertThat(tracker.replace(item.getId(), replaced)).isTrue();
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(replaced.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDeleteThenTrueAndItemRemoved() {
        try {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.delete(item.getId())).isTrue();
            assertThat(tracker.findById(item.getId())).isNull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAddItemsThenFindOnlyThem() {
        try {
            var item1 = new Item();
            item1.setName("item1");
            var item2 = new Item();
            item2.setName("item2");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findAll()).isEqualTo(List.of(item1, item2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFindByNameThenFound() {
        try {
            var item1 = new Item();
            item1.setName("item1");
            var item2 = new Item();
            item2.setName("item2");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findByName(item1.getName()).get(0)).isEqualTo(item1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
