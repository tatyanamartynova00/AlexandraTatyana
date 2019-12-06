package ru.ssau.tk.pion.alexandratatyana.io;

import ru.ssau.tk.pion.alexandratatyana.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
   public static void main(String[] args){
       try (BufferedReader linkedListReader = new BufferedReader(new FileReader("input/function.txt"));
            BufferedReader arrayReader = new BufferedReader(new FileReader("input/function.txt"))) {
           System.out.println(FunctionsIO.readTabulatedFunction(linkedListReader, new LinkedListTabulatedFunctionFactory()).toString());
           System.out.println(FunctionsIO.readTabulatedFunction(arrayReader, new ArrayTabulatedFunctionFactory()).toString());
       } catch (IOException exception) {
           exception.printStackTrace();
       }
   }
}

