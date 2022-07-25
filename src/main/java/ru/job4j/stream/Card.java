package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public static void main(String[] args) {
        List<Suit> suits = Stream.of(Suit.values()).toList();
        List<Value> values = Stream.of(Value.values()).toList();
        suits.stream()
                .flatMap(suit -> values.stream()
                        .map((value) -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}