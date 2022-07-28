package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinMethodTest {
    @Test
    public void test() {
        assertEquals(
                "a",
                MinMethod.min(List.of("ccc", "bb", "a"))
        );
    }
}