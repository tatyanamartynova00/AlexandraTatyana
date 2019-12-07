package ru.ssau.tk.pion.alexandratatyana.concurrent;

import ru.ssau.tk.pion.alexandratatyana.functions.ConstantFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction listTabulatedFunction = new LinkedListTabulatedFunction(new ConstantFunction(-1), 1, 500, 500);
        Thread readThread = new Thread(new ReadTask(listTabulatedFunction));
        Thread writeThread = new Thread(new WriteTask(listTabulatedFunction, 0.5));
        writeThread.start();
        readThread.start();
    }
}
