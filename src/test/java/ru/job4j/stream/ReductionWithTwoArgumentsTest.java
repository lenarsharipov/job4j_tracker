package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReductionWithTwoArgumentsTest {
    @Test
    public void test() {
        assertEquals(Integer.valueOf(5), ReductionWithTwoArguments.collect(List.of()));
        assertEquals(Integer.valueOf(5), ReductionWithTwoArguments.collect(List.of(1)));
        assertEquals(Integer.valueOf(10), ReductionWithTwoArguments.collect(List.of(1, 2)));
        assertEquals(Integer.valueOf(30), ReductionWithTwoArguments.collect(List.of(1, 2, 3)));
    }
}