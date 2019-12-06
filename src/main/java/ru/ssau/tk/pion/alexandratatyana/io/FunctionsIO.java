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

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
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

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(function.getCount());
        for (Point newPoint : function) {
            out.writeDouble(newPoint.x);
            out.writeDouble(newPoint.y);
        }
        out.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream in = new DataInputStream(inputStream);
        int length = in.readInt();
        double[] xValues = new double[length];
        double[] yValues = new double[length];
        for (int i = 0; i < length; i++) {
            xValues[i] = in.readDouble();
            yValues[i] = in.readDouble();
        }
        return factory.create(xValues, yValues);
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream outputs = new ObjectOutputStream(stream);
        outputs.writeObject(function);
        outputs.flush();
    }

    public static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream inputs = new ObjectInputStream(stream);
        return (TabulatedFunction) inputs.readObject();
    }
}
