package ru.ssau.tk.pion.alexandratatyana.concurrent;

import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;

public class ReadTask implements Runnable {
    private TabulatedFunction tabulatedFunction;
    ReadTask(TabulatedFunction tabulatedFunction){
        this.tabulatedFunction = tabulatedFunction;
    }
    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            synchronized (tabulatedFunction) {
                System.out.printf("After read: i = %d, x = %f, y = %f\n", i, tabulatedFunction.getX(i), tabulatedFunction.getY(i));
            }
        }
    }
}
