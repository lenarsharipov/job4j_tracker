package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.charAt(1) != right.charAt(1)) {
            return right.compareTo(left);
        }
        return left.substring(1)
                .compareTo(right.substring(1));
    }
}