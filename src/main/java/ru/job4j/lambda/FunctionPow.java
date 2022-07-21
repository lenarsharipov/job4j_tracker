package ru.job4j.lambda;

import java.util.function.Function;

public class FunctionPow {
    private static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }

    public static double calculate(double x) {
        return calculate((d) -> d * d, x);
    }
}
