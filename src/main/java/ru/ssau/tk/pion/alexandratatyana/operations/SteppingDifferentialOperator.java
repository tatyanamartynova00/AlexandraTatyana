package ru.ssau.tk.pion.alexandratatyana.operations;

import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;

abstract class SteppingDifferentialOperator implements DifferentialOperator<MathFunction> {
    protected double step;

    SteppingDifferentialOperator(double step) {
        if (step <= 0 || step == Double.POSITIVE_INFINITY || Double.isNaN(step)) {
            throw new IllegalArgumentException();
        }
        this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}

