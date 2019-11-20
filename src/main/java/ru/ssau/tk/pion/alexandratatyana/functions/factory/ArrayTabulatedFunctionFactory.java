package ru.ssau.tk.pion.alexandratatyana.functions.factory;

import ru.ssau.tk.pion.alexandratatyana.functions.ArrayTabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public ArrayTabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
