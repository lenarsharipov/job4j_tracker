package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName,  "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Quit the program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("First"));
        Item item2 = memTracker.add(new Item("Second"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), item.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Quit the program" + System.lineSeparator()
                + "=== Show all items ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + item2 + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator()
                + "1. Quit the program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("First"));
        Item item2 = memTracker.add(new Item("Second"));
        Input in = new StubInput(
                new String[] {"0", item2.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(),
                is("Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Quit the program" + System.lineSeparator()
                + "=== Find items by name ===" + System.lineSeparator()
                + item2 + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Quit the program" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("First"));
        Item item2 = memTracker.add(new Item("Second"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item2.getId()), "1"}
        );
       List<UserAction> actions = new ArrayList<>();
       actions.add(new FindByIdAction(out));
       actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(),
                is("Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Quit the program" + System.lineSeparator()
                        + "=== Find item by ID ===" + System.lineSeparator()
                        + item2 + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by ID" + System.lineSeparator()
                        + "1. Quit the program" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Quit the program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. Quit the program" + ln
                )
        );
    }

}