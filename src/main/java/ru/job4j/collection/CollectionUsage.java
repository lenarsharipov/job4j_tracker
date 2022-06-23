package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        Collection<String> list = new ArrayList<>();
        list.add("three");
        list.add("four");
        collection.retainAll(list);
        System.out.println("list collection");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("collection collection");
        for (String str : collection) {
            System.out.println(str);
        }
    }
}
