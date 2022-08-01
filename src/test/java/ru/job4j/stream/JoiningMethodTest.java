package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.StringJoiner;

class JoiningMethodTest {

    @Test
    public void test() {
        StringJoiner expect = new StringJoiner(
                System.lineSeparator(),
                "Prefix",
                "Suffix"
        );
        expect.add("A");
        expect.add("B");
        expect.add("C");
        assertEquals(
                expect.toString(),
                JoiningMethod.join(List.of(
                        "A", "B", "C"
                ))
        );
    }
}