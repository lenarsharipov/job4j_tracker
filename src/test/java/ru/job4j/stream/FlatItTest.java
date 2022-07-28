package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatItTest {

    @Test
    public void whenIt() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        assertEquals(
                FlatIt.flatten(it),
                List.of(1, 2, 3)
        );
    }
}