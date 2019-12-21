package ru.ssau.tk.pion.alexandratatyana.functions.factory;

import ru.ssau.tk.pion.alexandratatyana.functions.ArrayTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public ArrayTabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new ArrayTabulatedFunction(source, xFrom, xTo, count);
    }
}
