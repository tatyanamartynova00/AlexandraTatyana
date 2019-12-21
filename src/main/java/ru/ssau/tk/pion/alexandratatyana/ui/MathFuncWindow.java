package ru.ssau.tk.pion.alexandratatyana.ui;

import javax.swing.*;
import ru.ssau.tk.pion.alexandratatyana.functions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MathFuncWindow extends JFrame {
    private JComboBox<String> functionComboBox = new JComboBox<>();
    private JLabel fromLabel = new JLabel("from:");
    private JLabel toLabel = new JLabel("to:");
    private JLabel countLabel = new JLabel("count:");
    private JTextField countField = new JTextField();
    private JTextField fromField = new JTextField();
    private JTextField toField = new JTextField();
    private JButton okButton = new JButton("OK");
    private Map<String, MathFunction> nameFunctionMap = new HashMap<>();
    TabulatedFunction function;

    public static void main(JFrame args) {
        MathFuncWindow app = new MathFuncWindow();
        app.setVisible(true);
    }

    public static void main(TabulatedFunction function) {
        MathFuncWindow app = new MathFuncWindow(function);
        app.setVisible(true);
    }

    public MathFuncWindow(TabulatedFunction function) {
        super("CreateFunc");
        this.function = function;
        this.setBounds(300, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners();
    }

    public MathFuncWindow() {
        super("CreateFunc");
        this.setBounds(300, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners();
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

    public void addButtonListeners() {
        okButton.addActionListener(event -> {
            try {
                String func = (String) functionComboBox.getSelectedItem();
                MathFunction selectedFunction = nameFunctionMap.get(func);
                double from = Double.parseDouble(fromField.getText());
                double to = Double.parseDouble(toField.getText());
                int count = Integer.parseInt(countField.getText());
                function = new ArrayTabulatedFunction(selectedFunction, from, to, count);
                int k=1;
            } catch (Exception e) {
                ExceptionWindow errorWindow = new ExceptionWindow(this, e);
                errorWindow.showExceptionWindow(this, e);
            }
        });
    }
}
