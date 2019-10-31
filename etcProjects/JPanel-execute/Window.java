package com.panic.main;
import javax.swing.JFrame;
public class Window extends JFrame {
    public Window(){
        setTitle("Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MainPanel(1280,720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
