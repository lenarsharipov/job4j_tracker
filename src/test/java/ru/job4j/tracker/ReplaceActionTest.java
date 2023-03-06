package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class ReplaceActionTest {

    @Test
    public void execute() {
        var out = new StubOutput();
        var tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        var replacedName = "New item name";
        var rep = new ReplaceAction(out);
        var input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        var ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "=== Edit item ===" + ln + "Заявка изменена успешно." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }
}