package ru.ssau.tk.pion.alexandratatyana.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException {
    private static final long serialVersionUID = -1272633624943340026L;

    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}
