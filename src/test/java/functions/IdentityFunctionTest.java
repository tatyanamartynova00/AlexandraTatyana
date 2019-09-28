package functions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IdentityFunctionTest {
    @Test
        public void test(){
            IdentityFunction firstFunction = new IdentityFunction();
            assertEquals(firstFunction.apply(5), 5, 0.00001);        }

}