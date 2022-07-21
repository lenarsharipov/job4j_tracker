package ru.job4j.lambda;

import java.util.function.Function;

public class FunctionSqrt {
    private static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }

    public static double calculate(double x) {
        return calculate(Math::sqrt, x);
    }
}