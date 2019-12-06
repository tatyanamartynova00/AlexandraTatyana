package ru.ssau.tk.pion.alexandratatyana.exceptions;

public class InconsistentFunctionsException extends RuntimeException {
    private static final long serialVersionUID = -3668750085482103457L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String mess) {
        super(mess);
    }
}
