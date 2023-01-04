package ru.job4j.collection.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeRunner {
    public static void add() {
        Deque<String> deque = new LinkedList<>();
        deque.add("one");
        deque.add("two");
        deque.add("three");
        System.out.println(deque);

        deque.addLast("four");
        deque.addLast("five");
        System.out.println(deque);

        deque.addFirst("zero");
        System.out.println(deque);
    }

    public static void main(String[] args) {
        add();
    }
}
