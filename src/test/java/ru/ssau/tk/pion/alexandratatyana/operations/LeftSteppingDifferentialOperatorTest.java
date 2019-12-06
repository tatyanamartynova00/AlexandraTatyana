package ru.ssau.tk.pion.alexandratatyana.operations;

import ru.ssau.tk.pion.alexandratatyana.functions.SqrFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.CubeFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeftSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 4;
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(9), (Math.pow(9, 2) - Math.pow((9 - step), 2)) / step);
        assertEquals(differentialOperator.derive(new CubeFunction()).apply(2), (Math.pow(2, 3) - Math.pow((2 - step), 3)) / step);
    }
}

