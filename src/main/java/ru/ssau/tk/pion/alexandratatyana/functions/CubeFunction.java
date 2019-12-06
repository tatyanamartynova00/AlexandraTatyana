package ru.ssau.tk.pion.alexandratatyana.functions;

public class CubeFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.pow(x, 3);
    }
}
