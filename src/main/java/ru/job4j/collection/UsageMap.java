package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("ivanivanov@yandex.ru", "Ivan Ivanov");
        map.put("123", "One Two Three");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        map.put("ivanivanov@yandex.ru", "Ivan Ivanov Ivanovich");
        map.put("123", "UserName");
        System.out.println();
        System.out.println("Map.entrySet() usage");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        System.out.println("Map contains " + map.size() + " elements.");
        map.remove("123");
        System.out.println("Map contains " + map.size() + " elements.");
    }
}
