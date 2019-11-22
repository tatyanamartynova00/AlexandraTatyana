package ru.ssau.tk.pion.alexandratatyana.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ru.ssau.tk.pion.alexandratatyana.functions.*;
public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new SqrFunction(), 0, 10, 11);
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new CubeFunction(), 0, 10, 11);
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output/array_function.txt"))) {
            FunctionsIO.writeTabulatedFunction(fileWriter, arrayTabulatedFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter("output/linked_list_function.txt"));
            FunctionsIO.writeTabulatedFunction(fileWriter, linkedListTabulatedFunction);
        } catch (IOException e) {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
