package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalForPrimitiveTest {

    @Test
    public void test() {
        int[] data = {1, 2, 3};
        TerminalForPrimitive terminal = new TerminalForPrimitive(data);
        assertEquals(3, terminal.count());
        assertEquals(3, terminal.max());
        assertEquals(1, terminal.min());
        assertEquals(6, terminal.sum());
        assertEquals(2, terminal.avg(), 0.01);
    }

}