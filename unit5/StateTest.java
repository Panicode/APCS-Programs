//NOT FINISHED!!

import javax.swing.*;
import java.awt.*;
class Frame{
    private int width,height;
    private String title;
    private JFrame frame;
    public Frame(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createFrame();
    }
    private void createFrame(){
        frame=new JFrame(title); //setting title of JFrame
        frame.setSize(width,height); //initial width and height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //code stops when frame closes
        frame.setResizable(false); //resizability
        frame.setLocationRelativeTo(null); //'null' sets it to the middle of the screen
        frame.setVisible(true); //visibility, JFrames are set to false on startup
        frame.add(new Display());
    }
}
class Display extends JPanel{
        //setLayout(new FlowLayout());
        //removeAll();
    
    String[][] tests=new String[50][2];
    boolean ifWon=false;
    public Display(){
        setLayout(null);
        for(int i=0;i<tests.length;i++){
            
            repaint();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        if(!ifWon){
            
        }else{
            
        }
    }
}
public class StateTest{
    public static void main(String[] args){
        new Frame("State Test",900,700);
    }
}










