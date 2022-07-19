package ru.job4j.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyUsage {
    public boolean empty(String s) {
        return check(str -> str.isEmpty(), s);
    }

    public boolean startsWith(String s, String pref) {
        return check(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return check(str -> str.contains(key), s);
    }

    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }

    public String toUpperCase(String s) {
        return transform(str -> str.toUpperCase(), s);
    }

    public String concat(String s1, String s2) {
        return transform(str -> str.concat(s1), s2);
    }

    public String trim(String s) {
        return transform(str -> str.trim(), s);
    }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.isEmpty(), ""
                )
        );
        System.out.println("empty() : " + usage.empty(""));

        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.startsWith("Fun"), "Functional interface"
                )
        );
        System.out.println("startsWith() : "
                + usage.startsWith("Functional interface", "Fun"));

        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.contains("rn"), "Surname Name"
                )
        );
        System.out.println("contains() : " + usage.contains("Surname Name", "rn"));

        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        str -> str.toUpperCase(), "aBCdEfghKLmnpRstU"
                )
        );
        System.out.println("transform -> toUpperCase : " + usage.toUpperCase("aBCdEfghKLmnpRstU"));

        System.out.println(
                usage.transform(
                        str -> str.concat("работает корректно."), "Строка после преобразования: "
                )
        );
        System.out.println("transform -> concat : " + System.lineSeparator()
                + usage.concat("работает корректно", "Строка после преобразования: "));

        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        str -> str.trim(), "    aBC dEfghK Lmnp RstU        "
                )
        );
        System.out.println("transform -> trim : " + usage.trim("    aBC dEfghK Lmnp RstU        "));
    }

}