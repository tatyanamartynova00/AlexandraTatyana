package ru.ssau.tk.pion.alexandratatyana.operations;

import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;

public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator {
    RightSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction function) {
        return x -> (function.apply(x + step) - function.apply(x)) / step;

    }
}

