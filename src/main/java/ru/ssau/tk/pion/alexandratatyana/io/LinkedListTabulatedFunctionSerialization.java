package ru.ssau.tk.pion.alexandratatyana.io;

import ru.ssau.tk.pion.alexandratatyana.functions.*;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.LinkedListTabulatedFunctionFactory;

import ru.ssau.tk.pion.alexandratatyana.operations.TabulatedDifferentialOperator;

import java.io.*;
import static ru.ssau.tk.pion.alexandratatyana.io.FunctionsIO.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        TabulatedFunction function = new LinkedListTabulatedFunction(new SqrFunction(), 0, 10, 11);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction onrDerive = differentialOperator.derive(function);
        TabulatedFunction twoDerive = differentialOperator.derive(onrDerive);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {
            serialize(outputStream, function);
            serialize(outputStream, onrDerive);
            serialize(outputStream, twoDerive);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("output/serialized linked list functions.bin"))) {
            System.out.println(deserialize(inputStream).toString());
            System.out.println(deserialize(inputStream).toString());
            System.out.println(deserialize(inputStream).toString());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
