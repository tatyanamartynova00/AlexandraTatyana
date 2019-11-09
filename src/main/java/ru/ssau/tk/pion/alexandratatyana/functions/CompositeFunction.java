package ru.ssau.tk.pion.alexandratatyana.functions;

public class CompositeFunction implements MathFunction {
    private MathFunction oneFunction;
    private MathFunction twoFunction;

    public CompositeFunction(MathFunction oneFunction, MathFunction twoFunction) {
        this.oneFunction = oneFunction;
        this.twoFunction = twoFunction;
    }

    @Override
    public double apply(double x) {
        return twoFunction.apply(oneFunction.apply(x));
    }
}
