package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Michael", 35),
                new Person("Olga", 26),
                new Person("Anton", 20),
                new Person("Victor", 16),
                new Person("Anna", 29)
        );
        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .average();
        double avg = average.getAsDouble();
        System.out.println(avg);
    }
}
