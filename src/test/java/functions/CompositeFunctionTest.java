package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeFunctionTest {

        @Test
        public void test() {
            MathFunction OneFunction = new IdentityFunction();
            MathFunction TwoFunction = new CubeFunction();
            MathFunction CompositeFunction1 = new CompositeFunction(OneFunction, TwoFunction);
            assertEquals(CompositeFunction1.apply(2), 8, 0.0001);
        }
}
