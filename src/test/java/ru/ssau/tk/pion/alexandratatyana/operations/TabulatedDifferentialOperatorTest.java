package ru.ssau.tk.pion.alexandratatyana.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.pion.alexandratatyana.functions.ArrayTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TabulatedDifferentialOperatorTest {
    TabulatedDifferentialOperator array = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
    TabulatedDifferentialOperator isArray = new TabulatedDifferentialOperator();
    TabulatedDifferentialOperator linkedList = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
    double[] xValues = {5.3, 7.45, 15.};
    double[] yValues = {8.2, 9.85, 20.};
    ArrayTabulatedFunction myFunc = new ArrayTabulatedFunction(xValues, yValues);

    @Test
    public void testDerive() {
        var diffArray = array.derive(myFunc);
        assertEquals(diffArray.getY(0), (9.85 - 8.2) / (7.45 - 5.3), 0.0001);
        assertEquals(diffArray.getY(1), (20 - 9.85) / (15 - 7.45), 0.0001);
        assertEquals(diffArray.getY(2), (20 - 9.85) / (15 - 7.45), 0.0001);
    }

    @Test
    public void testGetFactory() {
        assertTrue(isArray.getFactory() instanceof ArrayTabulatedFunctionFactory);
        assertTrue(linkedList.getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        isArray.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(isArray.getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testDeriveSynchronously() {
        var diffArray = array.deriveSynchronously(myFunc);
        assertEquals(diffArray.getY(0), (9.85 - 8.2) / (7.45 - 5.3), 0.0001);
        assertEquals(diffArray.getY(1), (20. - 9.85) / (15. - 7.45), 0.0001);
        assertEquals(diffArray.getY(2), (20. - 9.85) / (15. - 7.45), 0.0001);
    }
}