package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(Map<Integer, String> name,
                                                   Map<Integer, String> surname) {
        for (Integer key : name.keySet()) {
            name.computeIfPresent(key, (k, v) -> v + " " + surname.get(key));
        }
        return name;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Joan");
        map.computeIfPresent("name", (key, value) -> key + ", " + value);
        System.out.println(map.get("name")); //output: name, Joan

        Map<String, String> map2 = new HashMap<>();
        map2.computeIfPresent("awesome key", (key, value) -> key + ", " + value);
        System.out.println(map2.get("awesome key")); //output: null

        Map<String, String> map3 = new HashMap<>();
        map3.computeIfAbsent("awesome key", key -> key + ", " + "amazing value");
        System.out.println(map3.get("awesome key")); //output: awesome key, amazing value

        Map<String, String> map4 = new HashMap<>();
        map4.put("awesome key", "cool value");
        map4.computeIfAbsent("awesome key", key -> key + ", " + "amazing value");
        System.out.println(map4.get("awesome key")); //output: cool value

    }
}