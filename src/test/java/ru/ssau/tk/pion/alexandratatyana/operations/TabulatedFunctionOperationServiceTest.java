package ru.ssau.tk.pion.alexandratatyana.operations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.ssau.tk.pion.alexandratatyana.functions.Point;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.*;

public class TabulatedFunctionOperationServiceTest {
    double[] firstXValues = new double[]{2.1, 3, 5.4, 7};
    double[] firstYValues = new double[]{1, 2, 6, 23};
    double [] secondXValues = new double []{8., 6., 2., 1.3};
    double [] secondYValues = new double[]{5., 1., 7., 3.};
    @Test
    public void testAsPoints() {
        int i = 0;
        TabulatedFunction mass = (new ArrayTabulatedFunctionFactory()).create(firstXValues, firstYValues);
        Point[] points = TabulatedFunctionOperationService.asPoints((TabulatedFunction) mass);
        for (Point point : points) {
            assertEquals(point.x, mass.getX(i));
            assertEquals(point.y, mass.getY(i++));
        }
    }

    @Test
    public void testGetFactory() {
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        assertTrue(new TabulatedFunctionOperationService().getFactory() instanceof TabulatedFunctionFactory);
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        tabulatedFunctionOperationService.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService.setFactory(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSum() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.sum(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] + secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.sum(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] + secondYValues[j++]);
        }
    }

    @Test
    public void testSubtract() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.subtract(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] - secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.subtract(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] - secondYValues[j++]);
        }
    }

    @Test
    public void testMultiplication() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.multiply(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] * secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.multiply(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] * secondYValues[j++]);
        }
    }

    @Test
    public void testDivision() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.divide(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] / secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.divide(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] / secondYValues[j++]);
        }
    }
}


