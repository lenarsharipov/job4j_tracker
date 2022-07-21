package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional<Integer> rsl = max(data);
        rsl.ifPresent(val -> System.out.println("Max: " + rsl.get()));
    }

    private static Optional<Integer> max(int[] data) {
        if (data.length == 0) {
            return Optional.empty();
        }
        int max = data[0];
        for (int index = 1; index < data.length; index++) {
            if (max < data[index]) {
                max = data[index];
            }
        }
        return Optional.of(max);
    }
}