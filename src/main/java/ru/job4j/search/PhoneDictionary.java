package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = (Person person) -> person.getName().equals(key);
        Predicate<Person> bySurname = (Person person) -> person.getSurname().equals(key);
        Predicate<Person> byPhone = (Person person) -> person.getPhone().equals(key);
        Predicate<Person> byAddress = (Person person) -> person.getAddress().equals(key);
        Predicate<Person> combine = byName.or(bySurname).or(byPhone).or(byAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}