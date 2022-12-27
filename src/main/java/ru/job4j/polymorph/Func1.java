package ru.job4j.polymorph;

public interface Func1 {
    default double func(double x, double y) {
        System.out.println("func() from Func1");
        return x * x - 2 * y + 30;
    }

    default void funcMessage() {
        System.out.println("Сообщение из Func1");
    }

    private int getSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    default int getDoubleSum(int[] numbers) {
        return getSum(numbers) * 2;
    }

    default double getAverage(int[] numbers) {
        return getSum(numbers) * 1.0 / numbers.length;
    }

}
