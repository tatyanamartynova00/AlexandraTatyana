package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.pion.alexandratatyana.functions.SqrFunction;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {

    @Test
    void apply() {
        SqrFunction testFunction = new SqrFunction();
        assertEquals(testFunction.apply(5), 25, 0.001);
    }
}
