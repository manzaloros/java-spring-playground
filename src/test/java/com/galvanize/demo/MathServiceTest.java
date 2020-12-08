package com.galvanize.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {

    private final MathService mathService = new MathService("6", "3");
    private final MathService mathServiceIndefinite = new MathService();

    @Test
    void addition() {
        assertEquals("6 + 3 = 9", mathService.add());
    }

    @Test
    void additionIndefiniteArgs() {
        List<String> numbers = Arrays.asList("5", "4", "3");
        assertEquals("5 + 4 + 3 = 12", mathServiceIndefinite.add(numbers));
    }

    @Test
    void multiply() {
        assertEquals("6 * 3 = 18", mathService.multiply());
    }

    @Test
    void subtract() {
        assertEquals("6 - 3 = 3", mathService.subtract());
    }

    @Test
    void divide() {
        assertEquals("6 / 3 = 2", mathService.divide());
    }
}
