package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Демонстрация работы методов noneMatch(), anyMatch(), allMatch().
 * Указанные методы проверяют элементы потока на соответствие условию.
 * Все они принимают Predicate в качестве параметра (условия для проверки).
 * Все три метода являются терминальными.
 */
public class MatchExample {
    private final static List<String> STRING_LIST = Arrays.asList(
            "[One]", "[Two]", "[Three]", "[Four]", "[Five]"
    );

    /**
     * noneMatch() - возвращает true, если ни один
     * из элементов потока не удовлетворяет условию.
     */
    public static void noneMatch() {
        boolean rsl = STRING_LIST.stream()
                .noneMatch("Six"::contains);
        System.out.println(rsl);
    }

    /**
     * anyMatch() - возвращает true, если как минимум один
     * из элементов потока удовлетворяет условию.
     */
    public static void anyMatch() {
        boolean rsl = STRING_LIST.stream()
                .anyMatch(e -> e.endsWith("ee]"));
        System.out.println(rsl);
    }

    /**
     * allMatch() - возвращает true, если все элементы потока удовлетворяют условию.
     */
    public static void allMatch() {
        boolean rsl = STRING_LIST.stream()
                .allMatch(e -> e.startsWith("[") && e.endsWith("]"));
        System.out.println(rsl);
    }

    public static void main(String[] args) {
        noneMatch();
        anyMatch();
        allMatch();
    }
}
