package ru.job4j.polymorph;

public interface TestInterface {
    void test();

    default void hello() {
        System.out.println("Hello");
    }
}
