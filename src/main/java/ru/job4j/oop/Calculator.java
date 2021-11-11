package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator c1 = new Calculator();
        result = c1.multiply(2);
        System.out.println(result);
        result = Calculator.minus(4);
        System.out.println(result);
        result = c1.divide(5);
        System.out.println(result);
        result = c1.sumAllOperation(1);
        System.out.println(result);
    }

}