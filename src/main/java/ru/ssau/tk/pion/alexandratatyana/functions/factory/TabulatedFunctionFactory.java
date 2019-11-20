package ru.ssau.tk.pion.alexandratatyana.functions.factory;

import ru.ssau.tk.pion.alexandratatyana.functions.*;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
}
