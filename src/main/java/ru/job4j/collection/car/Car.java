package ru.job4j.collection.car;

import java.util.*;

public class Car implements Comparable<Car> {
    private String name;
    private String color;
    private int speed;

    public Car(String name, String color, int speed) {
        this.name = name;
        this.color = color;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car cars = (Car) o;
        return speed == cars.speed && Objects.equals(name, cars.name)
                && Objects.equals(color, cars.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, speed);
    }

    @Override
    public String toString() {
        return "Cars{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", speed=" + speed
                + '}';
    }

    @Override
    public int compareTo(Car another) {
        return name.compareTo(another.name);
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(
                List.of(
                        new Car("toyota", "red", 30),
                        new Car("bmw", "color", 40),
                        new Car("lada", "white", 60),
                        new Car("kia", "blue", 60)
                )
        );
        System.out.println(cars);
        Collections.sort(cars);
        System.out.println(cars);
        cars.sort(Comparator.reverseOrder());
        System.out.println(cars);
        cars.sort(new CompareCarByDescColor());
        System.out.println(cars);
        cars.sort(new CompareCarByAscColor());
        System.out.println(cars);
    }
}
