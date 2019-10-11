package ru.ssau.tk.pion.alexandratatyana.functions;

public class CompositeFunction implements MathFunction {
    private MathFunction OneFunction;
    private MathFunction TwoFunction;

    public CompositeFunction(MathFunction OneFunction, MathFunction TwoFunction) {
        this.OneFunction = OneFunction;
        this.TwoFunction = TwoFunction;
    }

    @Override
    public double apply(double x) {
        return TwoFunction.apply(OneFunction.apply(x));
    }
}
