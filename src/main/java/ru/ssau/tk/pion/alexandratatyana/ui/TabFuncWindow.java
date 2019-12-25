package ru.ssau.tk.pion.alexandratatyana.ui;

import ru.ssau.tk.pion.alexandratatyana.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.pion.alexandratatyana.functions.TabulatedFunction;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TabFuncWindow extends JDialog {
    private List<Double> xValues = new ArrayList<>();
    private List<Double> yValues = new ArrayList<>();
    private AbstractTableModel tableModel = new MyTableModel(xValues, yValues);
    private JTable table = new JTable(tableModel);
    private JLabel label = new JLabel("Enter the number of points:");
    private JTextField countField = new JTextField();
    private JButton inputButton = new JButton("Enter");
    private JButton createButton = new JButton("Create");
    private TabulatedFunctionFactory factory;
    private TabulatedFunction function;

    public static void main(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        TabFuncWindow app = new TabFuncWindow(factory, callback);
        app.setVisible(true);
    }

    public TabFuncWindow(TabulatedFunctionFactory factory, Consumer<? super TabulatedFunction> callback) {
        setModal(true);
        this.setBounds(300, 300, 500, 500);
        this.factory = factory;
        addButtonListeners(callback);
        compose();
        inputButton.setEnabled(false);
        createButton.setEnabled(false);
    }

    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(createButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(createButton)
        );
    }

    public void addButtonListeners(Consumer<? super TabulatedFunction> callback) {
        addListenerForInputButton();
        addListenerForCreateButton(callback);
        addListenerForCountButton();
    }

    public void clearTable(int n) {
        for (int i = 0; i < n; i++) {
            xValues.remove(n - i - 1);
            yValues.remove(n - i - 1);
            tableModel.fireTableDataChanged();
        }
    }

    public void addListenerForInputButton() {
        inputButton.addActionListener(event -> {
            try {
                createButton.setEnabled(false);
                int count = Integer.parseInt(countField.getText());
                clearTable(tableModel.getRowCount());
                for (int i = 0; i < count; i++) {
                    xValues.add(0.);
                    yValues.add(0.);
                    tableModel.fireTableDataChanged();
                }
                if (tableModel.getRowCount() > 1) {
                    createButton.setEnabled(true);
                }
            } catch (Exception e) {
                new ExceptionWindow(this, e);
            }
        });
    }

    public void addListenerForCreateButton(Consumer<? super TabulatedFunction> callback) {
        createButton.addActionListener(event -> {
            try {
                double[] x = new double[xValues.size()];
                double[] y = new double[xValues.size()];
                x[0] = xValues.get(0);
                y[0] = yValues.get(0);
                for (int i = 1; i < xValues.size(); i++) {
                    if (xValues.get(i - 1) > xValues.get(i)) {
                        throw new ArrayIsNotSortedException();
                    }
                    x[i] = xValues.get(i);
                    y[i] = yValues.get(i);
                }
                function = factory.create(x, y);
                callback.accept(function);
                this.dispose();
            } catch (Exception e) {
                new ExceptionWindow(this, e);
            }
        });
    }

    public void addListenerForCountButton() {
        countField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChanged();
            }

            private void onChanged() {
                inputButton.setEnabled(!countField.getText().isEmpty());
            }
        });
    }
}
