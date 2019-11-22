package ru.ssau.tk.pion.alexandratatyana.io;

import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.*;


public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("input/binary function.bin"))) {
            TabulatedFunction array = FunctionsIO.readTabulatedFunction(inputStream, new ArrayTabulatedFunctionFactory());
            System.out.println(array.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(FunctionsIO.readTabulatedFunction(reader, new LinkedListTabulatedFunctionFactory()).toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
