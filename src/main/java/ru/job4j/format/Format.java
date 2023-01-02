package ru.job4j.format;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name) {
        System.out.println(String.format("Hello! I am %s", name));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(
                String.format(
                        "Hello! I am %s! Current date: %tF, Current time: %tT",
                        name, instance, instance
                )
        );
    }

    public static void getVariants() {
        System.out.format("%.3f%n", 0.987654321);
    }

    public static void getSpecial() {
        System.out.println(String.format(
                "%1$,+016.2f", 5000000.0000
        ));
    }

    public static void main(String[] args) {
        getGreeting("Helen");
        getGreetingAndTime("Ivan");
        getVariants();
        getSpecial();
    }

}
