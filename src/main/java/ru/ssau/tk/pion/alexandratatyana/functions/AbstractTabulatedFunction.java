package ru.ssau.tk.pion.alexandratatyana.functions;


import ru.ssau.tk.pion.alexandratatyana.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.pion.alexandratatyana.exceptions.ArrayIsNotSortedException;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    abstract protected int floorIndexOfX(double x);

    abstract protected double extrapolateLeft(double x);

    abstract protected double extrapolateRight(double x);

    abstract protected double interpolate(double x, int floorIndex);

    double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (rightY - leftY) * (x - leftX) / (rightX - leftX);
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else if (indexOfX(x) != -1) {
            return getY(indexOfX(x));
        } else {
            return interpolate(x, floorIndexOfX(x));
        }
    }


    @Override
    public String toString() {
        StringBuilder newLine = new StringBuilder();
        newLine.append(this.getClass().getSimpleName()).append(" ").append("size = ").append(this.getCount());
        for (Point newPoint : this) {
            newLine.append("\n").append("[").append(newPoint.x).append(";").append(" ").append(newPoint.y).append("]");
        }
        return newLine.toString();
    }

    protected static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("Lengths of arrays are different");
        }
    }

    protected static void checkSorted(double[] xValues) {
        for (int i = 1; i < xValues.length; i++) {
            if (xValues[i] <= xValues[i - 1]) {
                throw new ArrayIsNotSortedException("xValues array isn't sorted");
            }
        }
    }

}
