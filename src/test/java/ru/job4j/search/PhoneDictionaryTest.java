package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "222333", "Moscow")
        );
        var persons = phones.find("Ivanov");
        assertEquals(persons.get(0).getSurname(), "Ivanov");
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "222333", "Moscow")
        );
        var persons = phones.find("534872");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "222333", "Moscow")
        );
        var persons = phones.find("Moscow");
        assertEquals(persons.get(0).getSurname(), "Ivanov");
    }
}