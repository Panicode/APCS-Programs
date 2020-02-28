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
        frame.add(new Display());
        frame.setVisible(true); //visibility, JFrames are set to false on startup
    }
}
class Display extends JPanel{
    public Display(){
        setLayout(null);
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.WHITE);
    }
}
public class StateTest{
    public static void main(String[] args){
        new Frame("State Test",600,400);
    }
}
