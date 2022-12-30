package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "One", "Two", "Three", "Four", "Five", "Six"
        );
        List<String> rsl = strings
                .stream()
                .skip(3)
                .limit(1)
                .toList();
        System.out.println(rsl);

        String str = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("By default");
        System.out.println(str);
    }
}
