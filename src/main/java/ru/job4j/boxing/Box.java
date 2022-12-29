package ru.job4j.boxing;

public class Box {

    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = a;
        System.out.println("Integer b = " + b);

        int x = 2;
        num(x);
    }

}