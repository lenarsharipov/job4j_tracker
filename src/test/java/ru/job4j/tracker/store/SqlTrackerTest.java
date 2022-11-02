package ru.job4j.tracker.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertEquals(tracker.findById(item.getId()), item);
    }

    @Test
    public void whenSaveItemAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                new Item("item1"),
                new Item("item2"),
                new Item("item3")
        );
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(items.get(2));
        assertEquals(tracker.findAll(), items);
    }

    @Test
    public void whenDeleteItemAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                new Item("test1"),
                new Item("test2"),
                new Item("test3")
        );
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(items.get(2));
        assertTrue(tracker.delete(items.get(1).getId()));
        assertEquals(tracker.findAll(), List.of(items.get(0), items.get(2)));
    }

    @Test
    public void whenSaveItemsAndFindByNameTwoItemsThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> items = List.of(
                new Item("test1"),
                new Item("test2"),
                new Item("test3"),
                new Item("test1")
        );
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.add(items.get(2));
        tracker.add(items.get(3));
        assertEquals(tracker.findByName("test1"), List.of(items.get(0), items.get(3)));
    }

    @Test
    public void whenSaveItemsAndReplaceThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item item = new Item("replaced");
        tracker.replace(item1.getId(), item);
        assertTrue(tracker.replace(item1.getId(), item));
        item1.setName(item.getName());
        assertEquals(tracker.findAll(), List.of(item1, item2, item3));
    }
}