package ru.job4j.lambda;

import java.util.function.Predicate;

public class MRPredicate {
    public static Predicate<String> predicate() {
        Predicate<String> pre = String::isEmpty;
        return pre;
    }
}
