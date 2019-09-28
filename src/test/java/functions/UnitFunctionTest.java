package functions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UnitFunctionTest {

    @Test
    public void testApply() {
        MathFunction x = new UnitFunction();
        assertEquals(x.apply(5), 1, 0.0001);
    }
}
