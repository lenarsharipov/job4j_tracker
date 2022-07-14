package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Info info : list) {
            String key = info.getCity();
            Integer value = info.getRainfall();
            map.merge(key, value, (oldVal, newVal) -> oldVal + newVal);
        }

        for (String key : map.keySet()) {
            Integer value = map.get(key);
            rsl.add(new Info(key, value));
        }
        rsl.sort(Comparator.reverseOrder());
        System.out.println(rsl);

        return rsl;
    }

    public static class Info implements Comparable<Info> {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "city='" + city + '\''
                    + ", rainfall=" + rainfall
                    + '}';
        }

        @Override
        public int compareTo(Info another) {
            return this.rainfall - another.rainfall;
        }
    }
}
