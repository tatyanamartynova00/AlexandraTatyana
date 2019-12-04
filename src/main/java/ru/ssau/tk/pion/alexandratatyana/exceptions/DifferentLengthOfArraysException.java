package ru.ssau.tk.pion.alexandratatyana.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException {
    private static final long serialVersionUID = 2854462004592518822L;
    public DifferentLengthOfArraysException() {
    }
    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}
