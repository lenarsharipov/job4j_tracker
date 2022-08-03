package ru.job4j.records;

public class Program {
    public static void main(String[] args) {
        Person tom = new Person("Tom", "Smith", 36);
        System.out.println(tom);
        System.out.println(tom.age());
    }
}

interface Compute {
    double apply();
}

record Person(String name, int age) implements Compute  {
    private static char sex;

    Person(String firstName, String lastName, int age) {
        this(firstName + " " + lastName, age);
    }

    @Override
    public double apply() {
        return 0;
    }
}
