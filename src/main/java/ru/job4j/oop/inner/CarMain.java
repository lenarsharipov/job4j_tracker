package ru.job4j.oop.inner;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("BMW", "X5");
        Car.Transmission transmission = car.new Transmission();
        Car.Brakes brakes = car.new Brakes();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
        Car.TripComputer tripComputer = car.new TripComputer();
        tripComputer.getInfo();
    }

}
