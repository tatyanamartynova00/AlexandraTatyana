package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {

    @Test
    void apply() {
        SqrFunction testFunction = new SqrFunction();
        assertEquals(testFunction.apply(5), 25, 0.001);
    }
}
