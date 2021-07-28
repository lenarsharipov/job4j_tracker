/*
* 2.1. Рефакторинг - Расстояние между точками. [#122587]
* Задание:
* 1. Произведите рефакторинг кода.
* 2. Залейте изменения.
* 3. Оставьте ссылку.
* 4. Переведите ответственного на Петра Арсентьева.
 */

package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {
    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
}