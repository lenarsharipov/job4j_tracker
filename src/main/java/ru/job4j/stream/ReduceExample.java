package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());

        List<String> strings = List.of("One", "Two", "Three");
        Optional<String> str = strings.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(str.get());
    }
}
