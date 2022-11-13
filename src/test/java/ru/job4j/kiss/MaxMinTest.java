package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {
    private static Comparator<Integer> comparator;
    private static List<Integer> numbers;
    private static MaxMin maxMin;

    @BeforeAll
    public static void setUp() {
        comparator = Integer::compareTo;

        numbers = List.of(17, 1, 5, 6, 13, -15, 1, 39);

        maxMin = new MaxMin();
    }

    @Test
    void whenFindMax() {
        assertThat(maxMin.max(numbers, comparator)).isEqualTo(39);
    }

    @Test
    void whenFindMin() {
        assertThat(maxMin.min(numbers, comparator)).isEqualTo(-15);
    }

    @Test
    void whenEmptyListThenIllegalArgumentException() {
        List<Integer> list = new ArrayList<>();
        assertThatThrownBy(() -> maxMin.min(list, comparator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Passed arguments illegal");
    }

    @Test
    void whenNullListThenIllegalArgumentException() {
        List<Integer> list = null;
        assertThatThrownBy(() -> maxMin.min(list, comparator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Passed arguments illegal");
    }

    @Test
    void whenNullComparatorThenIllegalArgumentException() {
        Comparator<Integer> comp = null;
        assertThatThrownBy(() -> maxMin.min(numbers, comp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Passed arguments illegal");
    }

    @Test
    void whenOneElementThenThisElementAsMinAndMax() {
        List<Integer> list = List.of(1);
        assertThat(maxMin.max(list, comparator)).isEqualTo(1);
        assertThat(maxMin.min(list, comparator)).isEqualTo(1);
    }
}