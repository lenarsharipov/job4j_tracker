package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class DeleteActionTest {

    @Test
    void execute() {
        var out = new StubOutput();
        var tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        var del = new DeleteAction(out);
        var input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        del.execute(input, tracker);
        var ln = System.lineSeparator();
        assertThat(out.toString())
                .isEqualTo("=== Delete item ===" + ln + "Заявка удалена успешно." + ln);
        assertThat(tracker.findAll()).hasSize(0);
    }
}