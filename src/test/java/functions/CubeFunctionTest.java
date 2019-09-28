package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CubeFunctionTest {
    @Test
    public void test(){
        CubeFunction firstFunction = new CubeFunction();
        assertEquals(firstFunction.apply(2), 8, 0.00001);
    }
}
