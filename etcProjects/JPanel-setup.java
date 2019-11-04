//This is for a simple setup of a java JFrame. The "Launcher" class initializes and adds specific variables to the JFrame.

import javax.swing.*;
class Display {
    private int width,height;
    private String title;
    private JFrame frame;
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
    private void createDisplay(){
        frame=new JFrame(title); //setting title of JFrame
        frame.setSize(width,height); //initial width and height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //code stops when frame closes
        frame.setResizable(false); //resizability
        frame.setLocationRelativeTo(null); //'null' sets it to the middle of the screen
        frame.setVisible(true); //visibility
    }
}
public class Launcher {
    public static void main(String[] args){
        new Display("Title",500,500);
    }
}
