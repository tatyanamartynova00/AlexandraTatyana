package ru.ssau.tk.pion.alexandratatyana.concurrent;

import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

public class WriteTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;
    private double value;

    WriteTask(TabulatedFunction tabulatedFunction, double value) {
        this.tabulatedFunction = tabulatedFunction;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            synchronized (tabulatedFunction) {
                tabulatedFunction.setY(i, value);
                System.out.printf("Writing for index %d complete\n", i);
            }
        }
    }
}
