package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculateFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CalculateFunction function = new CalculateFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuatraticFunctionThenQuatraticResults() {
        CalculateFunction function = new CalculateFunction();
        List<Double> result = function.diapason(-1, 3, x -> x * x - 2 * x - 1);
        List<Double> expected = Arrays.asList(2D, -1D, -2D, -1D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        CalculateFunction function = new CalculateFunction();
        List<Double> result = function.diapason(-1, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(0.5D, 1D, 2D, 4D);
        assertThat(result, is(expected));
    }
}