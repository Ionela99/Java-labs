package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DesignPanel designPanel;
    ControlPanel controlPanel;

    public MainFrame() {
        super("Add component");
        init();
        this.setLayout(new BorderLayout());
        rootPane.setPreferredSize(new Dimension(1900, 870));
        addComponents();
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.designPanel = new DesignPanel(this);
        this.controlPanel = new ControlPanel(this);

        pack();
    }

    private void addComponents(){
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel, BorderLayout.CENTER);
    }
}