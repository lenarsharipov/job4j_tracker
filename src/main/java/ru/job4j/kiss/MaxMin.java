package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Passed arguments illegal");
        }
        return compare(value, comparator.reversed());
    }

    private <T> T compare(List<T> value, Comparator<T> comparator) {
        if (value == null || value.isEmpty() || comparator == null) {
            throw new IllegalArgumentException("Passed arguments illegal");
        }
        var rsl = value.get(0);
        if (value.size() == 1) {
            return rsl;
        }

        for (int i = 1; i < value.size(); i++) {
            var val = value.get(i);
            rsl = comparator.compare(rsl, val) > 0 ? rsl : val;
        }
        return rsl;
    }

}