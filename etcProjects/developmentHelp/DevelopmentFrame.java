import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Launcher{
    public static void main(String[] args){
        Game game= new Game("TBG",640,360);
        game.start();
    }
}
class Display {
    private int width,height;
    private String title;
    private JFrame frame;
    private Canvas canvas;
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

        //canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height)); //startup size
        canvas.setMaximumSize(new Dimension(width, height)); //minimum size
        canvas.setMinimumSize(new Dimension(width, height)); //maximum size

        frame.add(canvas); //adds canvas
        frame.pack(); //packs it to the dimensions
    }
    /*(commented out for the sole purpose of becoming a resizable display.)
    public int getWidth(){
        return frame.getWidth();
    }
    public int getHeight(){
        return frame.getHeight();
    }
    */
    public Canvas getCanvas() {
        return canvas;
    }
}
class Game implements Runnable{ //implements threads
    private Display display;
    public int width, height;
    public String title;

    private boolean running=false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;


    public Game(String title,int width,int height){
        this.width=width;
        this.height=height;
        this.title=title;
    }
    private void init(){
        display = new Display(title,width,height); //initializes display
    }
    private void tick(){

    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();/*gets the canvas from the Display class, and then gets a
                                                  BufferStrategy from that canvas, sets to bs (initial BufferStrategy)*/
        //a BufferStrategy is a way to draw graphics onto a canvas using buffers, in order to compile all information.
        if(bs==null){
            display.getCanvas().createBufferStrategy(3); //creates 3 buffers to compile info
            return; //returns out of the statement because it initializes the BufferStrategy
        }
        g=bs.getDrawGraphics(); //sets graphics to the final buffer.
        //clearing screen
        g.clearRect(0,0,width,height);
        //drawing

        g.fillRect(1, 2, 40, 40);

        //end drawing
        bs.show();
        g.dispose();
    }
    public void run(){ //start method starts this
        init();
        while(running){
            //width=display.getWidth();
            //height=display.getHeight();
            tick();
            render();
        }
        stop(); //stops the program when the "running" variable is false
    }
    public synchronized void start(){ //threaded and synchronized for multi-runs. able to be called ..anytime..
        if(running)return; //great piece of code; returns to nothing if the program is already running
        running=true;
        thread = new Thread(this); //calls upon the Main class
        thread.start(); //starts the run method
    }
    public synchronized void stop(){
        if(!running)return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ImageLoader{ //just loads images
    //java stores images in a "BufferedImage" object
    public static BufferedImage loadImage(String path){
        try{ //this will not halt the code just in case an image isn't loaded
            return ImageIO.read(ImageLoader.class.getResource(path)); //returns "BufferedImage" object of a loaded image
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1); //exits the code efficiently
        }
        return null; //needed in order for java to not be angry at me
    }
}
