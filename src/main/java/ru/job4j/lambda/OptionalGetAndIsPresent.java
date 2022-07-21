package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        Optional<Integer> rsl = indexOf(data, el);
        return rsl.orElse(-1);
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
            for (int index = 0; index < data.length; index++) {
                if (data[index] == el) {
                    return Optional.of(index);
                }
            }
            return Optional.empty();
    }
}