package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapToIntMethodTest {

    @Test
    public void test() {
        assertEquals(294, MapToIntMethod.sum(List.of('a', 'b', 'c')));
    }

}