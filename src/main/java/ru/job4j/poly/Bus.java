package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("driving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of passengers: " + count);
    }

    @Override
    public double refuel(int amount) {
        return amount * 70;
    }
}
