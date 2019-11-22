package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTabulatedFunctionTest {
    double[] xValues = {0, 0.5, 1.};
    double[] yValues = {0, 0.25, 1.};
    double[] zValues = {0.1, 0.2, 0.3};
    ArrayTabulatedFunction array = new ArrayTabulatedFunction(xValues, yValues);
    LinkedListTabulatedFunction linkedList = new LinkedListTabulatedFunction(xValues, yValues);
    String strLinkedList = "LinkedListTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    String strArray = "ArrayTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    ArrayTabulatedFunction testArray = new ArrayTabulatedFunction(xValues, zValues);
    String strTest = "ArrayTabulatedFunction size = 3\n[0.0; 1.0]\n[0.5; 2.0]\n[1.0; 3.0]";

    @Test
    public void testTestToString() {
        assertEquals(strArray, array.toString());
        assertEquals(strLinkedList, linkedList.toString());
        assertEquals(strTest, testArray.toString());
    }

}