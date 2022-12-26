package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Иван", 30);
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        System.out.println(person);

        PersonRecord record = new PersonRecord("Ivan", 35);
        System.out.println("Name: " + record.name() + ", Age: " + record.age());
        System.out.println(record);
        PersonRecord record1 = new PersonRecord("Ivan", 35);
        System.out.println(record.equals(record1));
    }
}
