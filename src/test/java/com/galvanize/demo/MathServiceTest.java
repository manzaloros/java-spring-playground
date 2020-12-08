package com.galvanize.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {

    private final MathService mathService = new MathService("5", "3");
    private final MathService mathServiceIndefinite = new MathService();

    @Test
    void addition() {
        assertEquals("5 + 3 = 8", mathService.add());
    }

    void additionIndefiniteArgs() {
        List<String> numbers = Arrays.asList("5", "4", "3");
        assertEquals("5 + 4 + 3 = 12", mathServiceIndefinite.add());
    }
}
