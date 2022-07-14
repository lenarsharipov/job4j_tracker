package ru.job4j.map;

import java.util.HashMap;
import java.util.*;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Integer> map = new TreeMap<>();
        for (String key : strings) {
            map.computeIfPresent(key, (k, v) -> map.get(key) + 1);
            map.putIfAbsent(key, 1);
        }

        Map<String, Boolean> rsl = new HashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                rsl.put(key, true);
            } else {
                rsl.put(key, false);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {

    }
}
