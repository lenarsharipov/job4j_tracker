package ru.job4j.oop.inner;

public class BirdMain {
    public static void main(String[] args) {
        Bird bird = new Bird() {
            @Override
            public void fly() {
                System.out.println("Parrot is flying over grass");
            }

            public void flyInside() {
                System.out.println("Parrot is flying inside the room");
            }
        };

        bird.fly();
    }
}
