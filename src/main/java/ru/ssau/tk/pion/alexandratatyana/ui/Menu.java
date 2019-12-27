package ru.ssau.tk.pion.alexandratatyana.ui;

import ru.ssau.tk.pion.alexandratatyana.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.pion.alexandratatyana.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame {
    private JButton inputButtonTable = new JButton("Create tabulated function");
    private JButton inputButtonMath = new JButton("Create simple function");
    private JButton inputButtonFactory = new JButton("Сhoose the type of factory");
    private JButton openButton = new JButton("Open function");
    private JButton saveButton = new JButton("Save function");
    private JButton closeButton = new JButton("Close");
    private List<Double> xValues = new ArrayList<>();
    private JFrame frame;
    private List<Double> yValues = new ArrayList<>();
    private TableModelMainWindow tableModel = new TableModelMainWindow();
    private JTable table = new JTable(tableModel);
    private TabulatedFunctionFactory factory;

    public Menu() {
        setTitle("Menu");
        setBounds(300, 200, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionPerformed();
        compose();
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void addButtonListeners() {
        addListenerForCloseButton();
    }

    public void addListenerForCloseButton() {
        closeButton.addActionListener(event -> {
            try {
                frame.setVisible(false);
                int resDlg = JOptionPane.showConfirmDialog(null, "Exit ?", "", JOptionPane.YES_NO_OPTION);
                if (resDlg == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    frame.setVisible(true);
                }
            } catch (Exception e) {
                new ExceptionWindow(this, e);
            }
        });
    }

    public void wrapTable(int countOld, int countNew) {
        tableModel.fireTableDataChanged();
        for (int i = 0; i < countOld; i++) {
            xValues.remove(countOld - i - 1);
            yValues.remove(countOld - i - 1);
        }
        for (int i = 0; i < countNew; i++) {
            xValues.add(tableModel.getFunction().getX(i));
            yValues.add(tableModel.getFunction().getY(i));
        }
    }

    public void actionPerformed() {
        inputButtonTable.addActionListener(event -> {
                    try {
                        int countOld = xValues.size();
                        TabFuncWindow.main(factory, data -> tableModel.setFunction(data));
                        int countNew = tableModel.getFunction().getCount();
                        wrapTable(countOld, countNew);
                    } catch (Exception e) {
                        if (e instanceof NullPointerException) {
                            e.printStackTrace();
                        } else
                            new ExceptionWindow(this, e);
                    }
                }
        );
        inputButtonMath.addActionListener(event -> {
            try {
                int countOld = xValues.size();
                MathFuncWindow.main(factory, data -> tableModel.setFunction(data));
                int countNew = tableModel.getFunction().getCount();
                wrapTable(countOld, countNew);
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    e.printStackTrace();
                } else
                    new ExceptionWindow(this, e);
            }
        });
        inputButtonFactory.addActionListener(event -> {
            try {
                SettingWindow.main(factory);
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    e.printStackTrace();
                } else
                    new ExceptionWindow(this, e);
            }
        });
        openButton.addActionListener(event -> {
            try {
                int countOld = xValues.size();
                FileReader.main(data -> tableModel.setFunction(data));
                int countNew = tableModel.getFunction().getCount();
                wrapTable(countOld, countNew);
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    e.printStackTrace();
                } else
                    new ExceptionWindow(this, e);
            }
        });
        saveButton.addActionListener(event -> {
            try {
                FileWriter.main(tableModel.getFunction());
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    e.printStackTrace();
                } else
                    new ExceptionWindow(this, e);
            }
        });


       /*closeButton.addActionListener(event -> {
           try {
               FileWriter.main(tableModel.getFunction());
           } catch (Exception e) {
               if (e instanceof NullPointerException) {
                   e.printStackTrace();
               } else
                   new ExceptionWindow(this, e);
           }
       });*/
       /*closeButton.addActionListener(event -> {
           try {
               int countOld = xValues.size();
               FileReader.main(data -> tableModel.setFunction(data));
               int countNew = tableModel.getFunction().getCount();
               wrapTable(countOld, countNew);
           } catch (Exception e) {
               if (e instanceof NullPointerException){
                   e.printStackTrace();
               }else
                   new ExceptionWindow(this, e);
           }
       });*/

    }

    ;


    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(inputButtonTable)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonFactory)
                        .addComponent(openButton)
                        .addComponent(saveButton)
                        .addComponent(closeButton))
                .addComponent(tableScrollPane)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputButtonTable)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonFactory)
                        .addComponent(openButton)
                        .addComponent(saveButton)
                        .addComponent(closeButton))
                .addComponent(tableScrollPane)
        );
    }

    public static void main(String[] args) {
        Menu window = new Menu();
        window.setVisible(true);
    }
}
