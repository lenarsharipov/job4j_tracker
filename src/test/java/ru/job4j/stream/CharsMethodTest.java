package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharsMethodTest {

    @Test
    public void test() {
        String input = "123";
        List<Character> expect = List.of('1', '2', '3');
        assertEquals(expect, CharsMethod.symbols(input));
    }

}