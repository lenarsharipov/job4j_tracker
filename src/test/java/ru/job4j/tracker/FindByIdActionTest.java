package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByIdActionTest {
    @Test
    void execute() {
        var out = new StubOutput();
        var tracker = new MemTracker();
        var item = new Item("FindById item");
        tracker.add(item);
        var findById = new FindByIdAction(out);
        var input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findById.execute(input, tracker);
        var ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by ID ===" + ln + item + ln);
    }
}