package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.pion.alexandratatyana.functions.CompositeFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.CubeFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.IdentityFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeFunctionTest {

    @Test
    public void test() {
        MathFunction oneFunction = new IdentityFunction();
        MathFunction twoFunction = new CubeFunction();
        MathFunction CompositeFunction1 = new CompositeFunction(oneFunction, twoFunction);
        assertEquals(CompositeFunction1.apply(2), 8, 0.0001);
    }
}
