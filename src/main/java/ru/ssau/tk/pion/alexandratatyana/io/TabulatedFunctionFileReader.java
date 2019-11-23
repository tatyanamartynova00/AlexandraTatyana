package ru.ssau.tk.pion.alexandratatyana.io;

import ru.ssau.tk.pion.alexandratatyana.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input/function.txt"))) {
            System.out.println(FunctionsIO.readTabulatedFunction(reader, new LinkedListTabulatedFunctionFactory()).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input/function.txt"));
            System.out.println(FunctionsIO.readTabulatedFunction(reader, new ArrayTabulatedFunctionFactory()).toString());
        } catch (IOException e) {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exec) {
                exec.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
