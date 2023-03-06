package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByNameActionTest {
    @Test
    void execute() {
        var tracker = new MemTracker();
        var out = new StubOutput();
        var item = new Item("Find by name");
        tracker.add(item);
        var input = mock(Input.class);
        var findByName = new FindByNameAction(out);
        when(input.askStr(any(String.class))).thenReturn("Find by name");
        findByName.execute(input, tracker);
        var ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + item + ln);
    }
}