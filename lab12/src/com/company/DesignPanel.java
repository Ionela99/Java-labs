package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
     final static int W = 1900, H = 870;
     final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }

    public void location(JComponent component) {
        Random random = new Random();
        int x = random.nextInt(W);
        int y = random.nextInt(H);
        int width = component.getPreferredSize().width;
        int height = component.getPreferredSize().height;
        component.setBounds(x, y, width, height);
        component.setToolTipText(component.getClass().getName());
        this.add(component);
        frame.repaint();
    }
}