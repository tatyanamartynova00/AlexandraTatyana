package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivideFunctionTest {
        @Test
        public void test(){
            DivideFunction firstFunction = new DivideFunction();
            assertEquals(firstFunction.apply(6), 3, 0.001);        }

    }

