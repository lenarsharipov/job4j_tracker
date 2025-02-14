package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollectorArithmeticTest {

    @Test
    public void whenWithout0() {
        int out = CollectorArithmetic.collect(List.of(1, 2, 3));
        assertEquals(6, out);
    }

    @Test
    public void whenWith0() {
        int out = CollectorArithmetic.collect(List.of(0, 2, 3));
        assertEquals(0, out);
    }

}