package ru.job4j.polymorph;

public class MainFunc implements Func1, Func2 {

    @Override
    public double func(double x, double y) {
        return Func2.super.func(x, y);
    }

    @Override
    public void funcMessage() {
        Func2.super.funcMessage();
    }

    public static void main(String[] args) {
        MainFunc mf = new MainFunc();
        System.out.println(mf.func(1, 1));
        mf.funcMessage();
    }
}
