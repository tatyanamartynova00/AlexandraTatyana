package ru.ssau.tk.pion.alexandratatyana.functions.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.ssau.tk.pion.alexandratatyana.functions.LinkedListTabulatedFunction;

class LinkedListTabulatedFunctionFactoryTest {
    @Test
    public void testCreate() {
        LinkedListTabulatedFunctionFactory testClass = new LinkedListTabulatedFunctionFactory();
        assertTrue(new LinkedListTabulatedFunction(new double[]{1.2, 2.5}, new double[]{1.2, 2.5}).getClass() == (testClass.create(new double[]{1.2, 2.5}, new double[]{1.2, 2.5})).getClass());
        assertTrue(testClass.create(new double[]{1.2, 2.5}, new double[]{1.2, 2.5}) instanceof LinkedListTabulatedFunction);
    }
}