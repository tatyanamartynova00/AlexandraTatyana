package functions;
import org.testng.annotations.Test;
import functions.IdentityFunction;
import static org.testng.Assert.*;

public class DivideFunctionTest {
        @Test
        public void test(){
            DivideFunction firstFunction = new DivideFunction();
            assertEquals(firstFunction.apply(6), 3, 0.001);        }

    }

