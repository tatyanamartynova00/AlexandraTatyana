package ru.ssau.tk.pion.alexandratatyana.ui;

import ru.ssau.tk.pion.alexandratatyana.exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ExceptionWindow  {
    ExceptionWindow(Component parent, Exception e) {
        showExceptionWindow(parent, e);
    }

    public void showExceptionWindow(Component parent, Exception e) {
        String head = generateMessageForException(e);
        JOptionPane.showMessageDialog(parent, e.getStackTrace(), head, JOptionPane.ERROR_MESSAGE);
    }

    private String generateMessageForException(Exception e) {
        if (e instanceof NumberFormatException) {
            return "Error!";//"Expected: Number, Found: String";
        }
        if (e instanceof ArrayIsNotSortedException) {
            return "Error!";//"Array is not sorted";
        }
        if (e instanceof IOException) {
            return "Error!";//"File is corrupted";
        }
        if (e instanceof InconsistentFunctionsException) {
            return "Error!";//"xValues are different";
        }
        return "Unknown error";
    }

}

