package ru.ssau.tk.pion.alexandratatyana.functions.factory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.ssau.tk.pion.alexandratatyana.functions.ArrayTabulatedFunction;
class ArrayTabulatedFunctionFactoryTest {
    @Test
    public void testCreate() {
        ArrayTabulatedFunctionFactory testClass = new ArrayTabulatedFunctionFactory();
        assertTrue(new ArrayTabulatedFunction(new double[]{1.2,2.5}, new double[]{1.2, 2.5}).getClass() == (testClass.create(new double[]{1.2,2.5}, new double[]{1.2,2.5})).getClass());
        assertTrue(testClass.create(new double[]{1.2,2.5}, new double[]{1.2,2.5}) != null);
    }
}