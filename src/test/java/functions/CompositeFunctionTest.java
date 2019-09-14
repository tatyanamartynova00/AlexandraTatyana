package functions;

import org.testng.annotations.Test;
import functions.CompositeFunction;
import static org.testng.Assert.*;

public class CompositeFunctionTest {

        @Test
        public void test() {
            MathFunction OneFunction = new IdentityFunction();
            MathFunction TwoFunction = new CubeFunction();
            MathFunction CompositeFunction1 = new CompositeFunction(OneFunction, TwoFunction);
            assertEquals(CompositeFunction1.apply(2), 8, 0.0001);
        }
}
