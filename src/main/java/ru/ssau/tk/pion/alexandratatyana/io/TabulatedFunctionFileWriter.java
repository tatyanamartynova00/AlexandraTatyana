package ru.ssau.tk.pion.alexandratatyana.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ru.ssau.tk.pion.alexandratatyana.functions.*;
public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new SqrFunction(), 0, 10, 11);
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new CubeFunction(), 0, 10, 11);
        try (BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter("output/array_function.txt"));
             BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {
            FunctionsIO.writeTabulatedFunction(fileWriter1, arrayTabulatedFunction);
            FunctionsIO.writeTabulatedFunction(fileWriter2, linkedListTabulatedFunction);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}