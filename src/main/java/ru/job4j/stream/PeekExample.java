package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Michael"),
                new StringBuilder("Ivan"),
                new StringBuilder("Oleg")
        );

        List<StringBuilder> editedNames = names
                .stream()
                .peek(el -> el.append(" (Job4j student)"))
                .sorted()
                .toList();
        System.out.println(editedNames);
    }

}