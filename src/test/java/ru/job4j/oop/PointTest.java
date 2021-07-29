package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00To20Then2() {
        double expected = 2;
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        double out = first.distance(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00To00Then0() {
        double expected = 0;
        Point first = new Point(0, 0);
        Point second = new Point(0, 0);
        double out = first.distance(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when16Minus5ToMinus70Then23Point53() {
        double expected = 23.53;
        Point first = new Point(16, -5);
        Point second = new Point(-7, 0);
        double out = first.distance(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when07toMinus135Then13Point15() {
        double expected = 13.15;
        Point first = new Point(0, 7);
        Point second = new Point(-13, 5);
        double out = first.distance(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when000To000Then0() {
        double expected = 0;
        Point first = new Point(0, 0, 0);
        Point second = new Point(0, 0, 0);
        double out = first.distance3d(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when123To456Then5Point20() {
        double expected = 5.20;
        Point first = new Point(1, 2, 3);
        Point second = new Point(4, 5, 6);
        double out = first.distance3d(second);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenNeg10Neg9To9Neg74Then13Point19() {
        double expected = 17.83;
        Point first = new Point(-1, 0, -9);
        Point second = new Point(9, -7, 4);
        double out = first.distance3d(second);
        Assert.assertEquals(expected, out, 0.01);
    }
}