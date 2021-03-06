package ru.ssau.tk.pion.alexandratatyana.operations;

import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;

public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator {
    LeftSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction function) {
        return x -> (function.apply(x) - function.apply(x - step)) / step;
    }
}

