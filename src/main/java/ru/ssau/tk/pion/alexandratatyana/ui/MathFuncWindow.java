package ru.ssau.tk.pion.alexandratatyana.ui;

import ru.ssau.tk.pion.alexandratatyana.functions.*;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MathFuncWindow extends JDialog {
    private JComboBox<String> functionComboBox = new JComboBox<>();
    private JLabel fromLabel = new JLabel("from:");
    private JLabel toLabel = new JLabel("to:");
    private JLabel countLabel = new JLabel("count:");
    private JTextField countField = new JTextField();
    private JTextField fromField = new JTextField();
    private JTextField toField = new JTextField();
    private JButton okButton = new JButton("OK");
    private Map<String, MathFunction> nameFunctionMap = new HashMap<>();
    TabulatedFunctionFactory factory;
    TabulatedFunction function;

    public static void main(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        MathFuncWindow app = new MathFuncWindow(factory, callback);
        app.setVisible(true);
    }

    public MathFuncWindow(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        setModal(true);
        this.factory = factory;
        this.setBounds(300, 200, 500, 150);
        fillMap();
        compose();
        addButtonListeners(callback);
    }


    public void fillMap() {
        nameFunctionMap.put("cube", new CubeFunction());
        nameFunctionMap.put("divide", new DivideFunction());
        nameFunctionMap.put("sqr", new SqrFunction());
        nameFunctionMap.put("zero", new ZeroFunction());
        nameFunctionMap.put("unit", new UnitFunction());
        String[] functions = new String[5];
        int i = 0;
        for (String string : nameFunctionMap.keySet()) {
            functions[i++] = string;
        }
        Arrays.sort(functions);
        for (String string : functions) {
            functionComboBox.addItem(string);
        }
    }

    public void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addComponent(fromField)
                        .addComponent(toLabel)
                        .addComponent(toField)
                        .addComponent(countLabel)
                        .addComponent(countField))
                .addComponent(functionComboBox)
                .addComponent(okButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fromLabel)
                        .addComponent(fromField)
                        .addComponent(toLabel)
                        .addComponent(toField)
                        .addComponent(countLabel)
                        .addComponent(countField))
                .addComponent(functionComboBox)
                .addComponent(okButton)
        );

    }

    public void addButtonListeners(Consumer<? super TabulatedFunction> callback) {
        okButton.addActionListener(event -> {
            try {
                String func = (String) functionComboBox.getSelectedItem();
                MathFunction selectedFunction = nameFunctionMap.get(func);
                double from = Double.parseDouble(fromField.getText());
                double to = Double.parseDouble(toField.getText());
                int count = Integer.parseInt(countField.getText());
                function = factory.create(selectedFunction, from, to, count);
                this.dispose();
            } catch (Exception e) {
                ExceptionWindow errorWindow = new ExceptionWindow(this, e);
                errorWindow.showExceptionWindow(this, e);
            }
        });
    }
}
