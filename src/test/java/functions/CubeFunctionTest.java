package functions;

import org.testng.annotations.Test;
import functions.CubeFunction;
import static org.testng.Assert.*;


public class CubeFunctionTest {
    @Test
    public void test(){
        CubeFunction firstFunction = new CubeFunction();
        assertEquals(firstFunction.apply(2), 8, 0.00001);
    }
}
