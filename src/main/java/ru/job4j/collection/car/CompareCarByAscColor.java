package ru.job4j.collection.car;

import java.util.Comparator;

public class CompareCarByAscColor implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car2.getColor().compareTo(car1.getColor());
    }
}
