package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " движется по железной дороге.");
    }

    @Override
    public void reFuel() {
        System.out.println(getClass().getSimpleName()
                + " заправляется дизельным топливом.");
    }
}
