package ru.ssau.tk.pion.alexandratatyana.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {
    private static final long serialVersionUID = -5486701546221462301L;

    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}

