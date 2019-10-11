package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.pion.alexandratatyana.functions.MathFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.ZeroFunction;

import static org.junit.jupiter.api.Assertions.*;

public class ZeroFunctionTest {

    @Test
    public void testApply() {
        MathFunction x = new ZeroFunction();
        assertEquals(x.apply(5), 0, 0.0001);
    }
}
