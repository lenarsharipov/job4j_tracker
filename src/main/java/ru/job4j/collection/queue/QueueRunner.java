package ru.job4j.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {

    public static void add() {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.add("first"));
        System.out.println(queue.add("second"));
        System.out.println(queue.add("third"));
        System.out.println(queue.add(null));
        System.out.println(queue);
    }

    public static void removeOrPoll() {
        Queue<String> queue = new LinkedList<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.remove();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }

    public static void offer() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        System.out.println(queue);

        Queue<String> queueFixedSize = new ArrayBlockingQueue<>(3);
        queueFixedSize.offer("one");
        queueFixedSize.offer("two");
        queueFixedSize.offer("three");
        queueFixedSize.offer("four");
        System.out.println(queueFixedSize);
    }

    public static void peekAndElement() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);
        System.out.println(queue.element());

    }

    public static void main(String[] args) {
        peekAndElement();
    }
}
