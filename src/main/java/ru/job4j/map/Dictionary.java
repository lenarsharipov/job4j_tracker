package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String value : strings) {
            String key = Character.toString(value.charAt(0));
            if (rsl.containsKey(key)) {
                rsl.get(key).add(value);
            }
            rsl.putIfAbsent(key, new ArrayList<String>(List.of(value)));
        }
        return rsl;
    }
}