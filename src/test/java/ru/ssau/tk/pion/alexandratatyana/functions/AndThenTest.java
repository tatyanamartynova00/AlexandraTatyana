package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AndThenTest {
    double[] x = new double[]{5., 6.};
    double[] y = new double[]{1., 3.};
    double[] z = new double[]{2., 4.};
    ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(x, y);
    LinkedListTabulatedFunction func2 = new LinkedListTabulatedFunction(y, z);
    SqrFunction func3 = new SqrFunction();

    @Test
    void andThen() {
        assertEquals(4., func1.andThen(func2).andThen(func3).apply(5.), 0.001);
    }
}
