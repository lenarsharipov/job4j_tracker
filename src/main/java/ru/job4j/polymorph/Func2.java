package ru.job4j.polymorph;

public interface Func2 extends Func1 {
    default double func(double x, double y) {
        System.out.println("func() from Func2");
        return x * x - y + 5;
    }

    default void funcMessage() {
        System.out.println("Сообщение из Func2");
    }
}
