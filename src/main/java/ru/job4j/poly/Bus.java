package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по шоссе.");
    }

    @Override
    public void reFuel() {
        System.out.println(getClass().getSimpleName()
                + " заправляется либо бензином, либо дизельным топливом, либо газом.");
    }
}