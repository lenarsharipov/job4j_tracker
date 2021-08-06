package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит в небе.");
    }

    @Override
    public void reFuel() {
        System.out.println(getClass().getSimpleName()
                + " заправляется авиационным топливом.");
    }
}
