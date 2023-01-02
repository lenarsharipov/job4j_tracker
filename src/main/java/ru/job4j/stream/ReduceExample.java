package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    public static void reduce() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());

        int summa = numbers.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(summa);
    }

    public static void reduceAccumulator() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        int summa = numbers.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(summa);

        List<String> strings = List.of("One", "Two", "Three");
        String rsl = strings.stream()
                .reduce("hello", (a, b) -> a + ", " + b);
        System.out.println(rsl);
    }

    public static void reduceAccumulatorCombiner() {
        List<Person> people = Arrays.asList(
                new Person("Michael", 35),
                new Person("Olga", 26),
                new Person("Anton", 20),
                new Person("Victor", 16),
                new Person("Anna", 29)
        );
        int sum = people.stream()
                .reduce(0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b
                );
        System.out.println(sum);
    }

    public static void main(String[] args) {
        reduce();
        reduceAccumulator();
        reduceAccumulatorCombiner();
    }
}
