package com.company;

import javax.swing.*;

public class MainFrame<ControlPanel> extends JFrame {
   // private static final int CENTER = ;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER

        //invoke the layout manager
        pack();
    }

    private void add(DrawingPanel canvas, int center) {
    }
}
