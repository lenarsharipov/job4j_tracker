package ru.job4j.oop.inner;

public class Car {
    private static String carManual = "Инструкция к автомобилю";
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public static TripComputer getTripComputer() {
        Car car = new Car("Brand", "Model");
        Car.TripComputer tripComputer = car.new TripComputer();
        return tripComputer;
    }

    public class Transmission {
        public void accelerate() {
            System.out.println("Ускорение");
        }
    }

    public class Brakes {
        public void brake() {
            System.out.println("Торможение");
        }
    }

    public class TripComputer {
        private String tripData = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Модель TripComputer: " + this.model);
            System.out.println("Модель Car: " + Car.this.model);
        }
    }

    public static class Manual {

        public static String getManual() {
            return carManual;
        }
    }
}
