package com.company;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Swing component");
    private final JTextField classNameField = new JTextField(25);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(15);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        createButton.addActionListener(e -> {
            JComponent component = createDynamicComponent(classNameField.getText());
            setComponentText(component, textField.getText());
            frame.designPanel.location(component);
        });
//        add(classNameLabel);
//        add(classNameField);
//        add(textLabel);
//        add(textField);
//        add(createButton);
    }

    private void setComponentText(JComponent component, String txt) {

        Class clazz = component.getClass();
        Method met = null;
        try {
            met = clazz.getMethod("Text", String.class);
            met.invoke(component, txt);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private JComponent createDynamicComponent(String className) {
        try {
            Class clazz = Class.forName(className);
            return (JComponent) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}