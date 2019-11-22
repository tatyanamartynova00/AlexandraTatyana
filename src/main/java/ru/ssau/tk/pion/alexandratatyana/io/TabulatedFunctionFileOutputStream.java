package ru.ssau.tk.pion.alexandratatyana.io;
import ru.ssau.tk.pion.alexandratatyana.functions.ArrayTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.*;
import java.io.FileOutputStream;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3};
        double[] yValues = {1, 2, 3};
        TabulatedFunction array = new ArrayTabulatedFunction(xValues, yValues);
        TabulatedFunction linkedList = new LinkedListTabulatedFunction(xValues, yValues);
        try (BufferedOutputStream outputStreamArr = new BufferedOutputStream(new FileOutputStream(new File("output/array function.bin")))) {
            FunctionsIO.writeTabulatedFunction(outputStreamArr, array);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (BufferedOutputStream outputStreamLink = new BufferedOutputStream(new FileOutputStream(new File("output/linked list function.bin")))) {
            FunctionsIO.writeTabulatedFunction(outputStreamLink, linkedList);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
}
