package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        String rsl = str.toLowerCase().replace(" ", "");
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < rsl.length(); i++) {
            char temp = rsl.charAt(i);
            map.putIfAbsent(temp, 1);
            map.computeIfPresent(temp, (key, value) -> map.get(temp) + 1);
        }
        List<Integer> sorted = new ArrayList<>(map.values());
        sorted.sort(Comparator.reverseOrder());
        char valRsl = ' ';
        for (Character ch : map.keySet()) {
            Integer val = map.get(ch);
            if (Objects.equals(val, sorted.get(0))) {
                valRsl = ch;
                break;
            }
        }
        return valRsl;
    }

    public static void main(String[] args) {
        String str = "Мама мыла раму";
        System.out.println(getMaxCount(str));
    }
}
