package ru.ssau.tk.pion.alexandratatyana.functions.factory;

import ru.ssau.tk.pion.alexandratatyana.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public LinkedListTabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }
}
