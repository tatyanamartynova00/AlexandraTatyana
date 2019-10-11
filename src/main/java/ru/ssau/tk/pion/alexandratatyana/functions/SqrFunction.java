package ru.ssau.tk.pion.alexandratatyana.functions;

import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;

public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x){
    return Math.pow(x,2);
}
}
