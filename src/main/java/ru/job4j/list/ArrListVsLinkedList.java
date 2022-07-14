package ru.job4j.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrListVsLinkedList {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("Hello");
        lst.add("Hello2");
        lst.add("Hello3");
        lst.add("Hello4");
        lst.add("World");
        lst.add("World1");
        lst.add("World12");

        for (String line : lst) {
            System.out.println(line);
        }
        System.out.println();
        List<String> lst2 = new LinkedList<>();
        lst2.add("Hello");
        lst2.add("Hello2");
        lst2.add("Hello3");
        lst2.add("Hello4");
        lst2.add("World");
        lst2.add("World1");
        lst2.add("World12");

        for (String line : lst2) {
            System.out.println(line);
        }
    }
}
