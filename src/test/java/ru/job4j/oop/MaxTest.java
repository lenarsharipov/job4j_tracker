package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenFirstMax2to3Then3() {
        int first = 2;
        int second = 3;
        int result = Max.max(first, second);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenFirstMax4To4Then4() {
        int first = 4;
        int second = 4;
        int result = Max.max(first, second);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenFirstMax5to1Then5() {
        int first = 5;
        int second = 1;
        int result = Max.max(first, second);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenSecondMax2to3to4Then4() {
        int first = 2;
        int second = 3;
        int third = 4;
        int result = Max.max(first, second, third);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenSecondMax4To4To4Then4() {
        int first = 4;
        int second = 4;
        int third = 4;
        int result = Max.max(first, second, third);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenSecondMax5to1to4Then5() {
        int first = 5;
        int second = 1;
        int third = 4;
        int result = Max.max(first, second, third);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenThirdMax2To3To4To5Then5() {
        int first = 2;
        int second = 3;
        int third = 4;
        int fourth = 5;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenThirdMax4To4To4To4Then4() {
        int first = 4;
        int second = 4;
        int third = 4;
        int fourth = 4;
        int result = Max.max(first, second, third, fourth);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenThirdMax5to1to4ToNeg8Then5() {
        int first = 5;
        int second = 1;
        int third = 4;
        int fourth = -8;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }
}
