package ru.job4j.stream;

import java.util.*;
import java.util.stream.IntStream;
import ru.job4j.stream.mapto.Person;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());

        OptionalInt min = IntStream
                .rangeClosed(1, 5)
                .min();
        System.out.println(min.getAsInt());

        List<Person> people = Arrays.asList(
                new Person("Michael", 35),
                new Person("Olga", 26),
                new Person("Anton", 20),
                new Person("Victor", 16),
                new Person("Anna", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::getAge));
        int age = youngestPerson.get().getAge();
        System.out.println(age);
    }
}
