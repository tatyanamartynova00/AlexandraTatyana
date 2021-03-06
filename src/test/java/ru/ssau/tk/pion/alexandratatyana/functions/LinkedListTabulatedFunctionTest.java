package ru.ssau.tk.pion.alexandratatyana.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunctionTest {
    double[] x = new double[]{1., 3., 5., 7., 9.};
    double[] y = new double[]{2., 4., 6., 8., 10.};
    LinkedListTabulatedFunction listOne = new LinkedListTabulatedFunction(x, y);
    LinkedListTabulatedFunction listTwo = new LinkedListTabulatedFunction(new SqrFunction(), 1, 3, 3);

    @Test
    void getCount() {
        assertEquals(5, listOne.getCount());
    }

    @Test
    void leftBound() {
        assertEquals(1., listOne.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(9., listOne.rightBound());
    }

    @Test
    void getX() {
        assertEquals(1., listOne.getX(0), 0.01);
        assertEquals(1., listTwo.getX(0), 0.01);
        assertEquals(5., listOne.getX(2), 0.01);
    }

    @Test
    void getY() {
        assertEquals(2., listOne.getY(0), 0.01);
        assertEquals(4., listTwo.getY(1), 0.01);
        assertEquals(8., listOne.getY(3), 0.01);
    }

    @Test
    void setY() {
        listOne.setY(1, 3.);
        assertEquals(3., listOne.getY(1), 0.01);
    }

    @Test
    void indexOfX() {
        assertEquals(-1, listTwo.indexOfX(4.));
        assertEquals(2, listOne.indexOfX(5.));
        assertEquals(3, listOne.indexOfX(7.));
        assertEquals(-1, listOne.indexOfX(0.5));
    }

    @Test
    void indexOfY() {
        assertEquals(2, listTwo.indexOfY(9.));
        assertEquals(1, listOne.indexOfY(4.));
        assertEquals(2, listOne.indexOfY(6.));
        assertEquals(-1, listOne.indexOfY(0.5));
    }

    @Test
    void floorIndexOfX() {
        assertEquals(0, listTwo.floorIndexOfX(1.));
        assertEquals(0, listOne.floorIndexOfX(1.1));
        assertEquals(1, listOne.floorIndexOfX(3));
    }

    @Test
    void interpolate() {
        assertEquals(4. + ((6. - 4.) / (5. - 3.)) * (3.5 - 3.), listOne.interpolate(3.5, 1));
    }

    @Test
    void extrapolateRight() {
        assertEquals(8. + ((10. - 8.) / (9. - 7.)) * (10.3 - 7), listOne.extrapolateRight(10.3));
    }

    @Test
    void extrapolateLeft() {
        assertEquals(2. + ((4. - 2.) / (3. - 1.)) * (0.8 - 1), listOne.extrapolateLeft(0.8));
    }

    @Test
    void iterator() {
        Iterator<Point> iterator = listOne.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listOne.getX(i++), point.x, 0.0001);
        }
        Iterator<Point> finalIterator = iterator;
        assertThrows(NoSuchElementException.class, () -> {
            Point point = finalIterator.next();
        });
        i = 0;
        for (Point point : listOne) {
            assertEquals(listOne.getX(i++), point.x, 0.0001);
        }
        iterator = listTwo.iterator();
        i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listTwo.getX(i++), point.x, 0.0001);
        }
        i = 0;
        for (Point point : listTwo) {
            assertEquals(listTwo.getX(i++), point.x, 0.0001);
        }
    }
}

