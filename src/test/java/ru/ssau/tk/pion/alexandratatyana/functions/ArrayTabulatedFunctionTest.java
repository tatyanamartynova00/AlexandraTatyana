package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTabulatedFunctionTest {
    private double[] xValues = {6.4, 7, 35};
    private double[] yValues = {7.2, 8, 36};
    ArrayTabulatedFunction myFunc = new ArrayTabulatedFunction(xValues, yValues);

    @Test
    void getCount() {
        assertEquals(3, myFunc.getCount(), 0.001);
    }

    @Test
void  getX() {
        assertEquals(6.4, myFunc.getX(0), 0.001);
        assertEquals(7, myFunc.getX(1), 0.001);
        assertEquals(35, myFunc.getX(2), 0.001);
    }

    @Test
void getY(){
        assertEquals(7.2, myFunc.getY(0), 0.001);
        assertEquals(8, myFunc.getY(1), 0.001);
        assertEquals(36, myFunc.getY(2), 0.001);
    }

    @Test
    void leftBound() {
        assertEquals(6.4, myFunc.leftBound(), 0.001);
    }

    @Test
    void rightBound() {
        assertEquals(35, myFunc.rightBound(), 0.001);

    }


    @Test
    void indexOfX() {
        assertEquals(-1, myFunc.indexOfX(1), 0.001);
        assertEquals(-1, myFunc.indexOfX(0), 0.001);
        assertEquals(-1, myFunc.indexOfX(2), 0.001);
    }

    @Test
    void indexOfY() {
        assertEquals(-1, myFunc.indexOfY(1), 0.001);
        assertEquals(-1, myFunc.indexOfY(0), 0.001);
        assertEquals(-1, myFunc.indexOfY(2), 0.001);
    }

    @Test
    void floorIndexOfX(){
        assertEquals ( 1 , myFunc . floorIndexOfX ( 7 ), 0,001 );
        assertEquals ( 0 , myFunc . floorIndexOfX ( 6.4 ), 0,001 );
    }
    @Test
    void  extrapolateLeft () {
        assertEquals ( 8 , myFunc . extrapolateLeft ( 7 ), 0,001 );
        assertEquals ( 7.2 , myFunc . extrapolateLeft ( 6.4 ), 0,001 )
    }
    @Test
    void extrapolateRight() {
        assertEquals(8, myFunc.extrapolateRight((7)), 0.001);
        assertEquals(36, myFunc.extrapolateRight(35), 0.001);
    }

    @Test
    void interpolate() {
        assertEquals(7.2, myFunc.interpolate(6.4, 0), 0.001);
        assertEquals(8, myFunc.interpolate(7, 1), 0.001);
    }



    }










