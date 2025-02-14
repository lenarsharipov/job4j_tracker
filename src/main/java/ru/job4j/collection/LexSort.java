package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftValue = Integer.parseInt(left.split(". ")[0]);
        int rightValue = Integer.parseInt(right.split(". ")[0]);
        return Integer.compare(leftValue, rightValue);
    }
}