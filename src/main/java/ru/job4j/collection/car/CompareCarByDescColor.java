package ru.job4j.collection.car;

import java.util.Comparator;

public class CompareCarByDescColor implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getColor().compareTo(car2.getColor());
    }
}