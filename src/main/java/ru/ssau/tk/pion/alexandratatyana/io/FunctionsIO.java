package ru.ssau.tk.pion.alexandratatyana.io;

import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.Point;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }
    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) throws IOException {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());
        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }
        writer.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException, NumberFormatException {
        int count = Integer.parseInt(reader.readLine());
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        NumberFormat formatter = NumberFormat.getInstance(Locale.forLanguageTag("ru"));
        for (int i = 0; i < count; i++) {
            String valString = reader.readLine();
            try {
                xValues[i] = formatter.parse(valString.split(" ")[0]).doubleValue();
                yValues[i] = formatter.parse(valString.split(" ")[1]).doubleValue();
            } catch (ParseException parse) {
                throw new IOException(parse);
            }
        }
        return factory.create(xValues, yValues);
    }
}
