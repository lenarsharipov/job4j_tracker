package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectorClassTest {

    @Test
    public void test() {
        assertEquals(
                List.of(1, 2, 3),
                CollectorClass.collect(List.of(1, 2, 3))
        );
    }
}