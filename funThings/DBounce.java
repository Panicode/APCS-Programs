import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
public class Launcher{
    public static void main(String[] args){
        Game game= new Game("TBG",640,360);
        game.start();
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

    //States
    private State gameState;
    //end States

    public Game(String title,int width,int height){
        this.width=width;
        this.height=height;
        this.title=title;
    }
    private void init(){ //initializing
        display = new Display(title,width,height); //initializes display
        Assets.init(); //asset initialization

        gameState=new GameState();
        State.setState(gameState);
    }
    private void tick(){
        if(State.getState()!=null){ //checks if there's a state active
            State.getState().tick();
        }
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
        if(State.getState()!=null){
            State.getState().render(g);
        }
        //end drawing
        bs.show();
        g.dispose();
    }
    public void run(){ //The launcher class starts this.
        init(); //initializing the code

        int fps = 60;
        double timePerTick = 1000000000/fps;
        /*measured in nanoseconds, divide it by desired FPS to check the wait time before going to another frame.*/
            double delta=0; //instance for the time spent before a frame is drawn
            long now; //instance for the time shown on the running loop
            long lastTime=System.nanoTime();//nanoTime returns the time of a computer in nanoseconds
            long timer=0;//instance to check if a second has passed
            int ticks=0;//instance to check how many ticks are drawn
        while(running){
            now=System.nanoTime();//initializing 'now' as the current time
            delta+=(now-lastTime)/timePerTick;//adding nanoseconds up to each other
            timer+=now-lastTime; //fps timer
            lastTime=now;//resetting lastTime to the current time
            if(delta>=1){
                tick();
                render();
                ticks++;//added ticks
                delta--;
            }
            if(timer>=1000000000){ //FPS counter!
                System.out.println("FPS: "+ticks);
                ticks=0;timer=0;
            }
        }
        stop(); //stops the program when the "running" variable is false
    }
    public synchronized void start(){ //threaded and synchronized for multi-runs. able to be called ..anytime..
        if(running)return; //returns to nothing if the program is already running
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
    public Canvas getCanvas() {
        return canvas;
    }
}
class ImageLoader{ //just loads images
    //java stores images in a "BufferedImage" object
    public static BufferedImage loadImage(String path){
        try{ //this will not halt the code just in case an image isn't loaded
            URL url =new URL(path);
            return ImageIO.read(url); //returns "BufferedImage" object of a loaded image
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1); //exits the code efficiently
        }
        return null; //needed in order for java to not be angry at me
    }
}
class SpriteLoader {
    private BufferedImage sheet;
    public SpriteLoader(BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop(int x,int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
class Assets {
    private static final int width=32,height=32; //width and height of each gridspace
    public static BufferedImage player,emptyTile,standTile,woodTile,fuelTank,greySlime,big,small;

    public static void init(){
        SpriteLoader sheet = new SpriteLoader(ImageLoader.loadImage("https://raw.githubusercontent.com/Panicode/TBG/master/resource/textures/sheet.png"));
        SpriteLoader sm= new SpriteLoader(ImageLoader.loadImage("https://raw.githubusercontent.com/Panicode/APCS-Programs/master/etcProjects/littlegame/small%20boy.png"));
        SpriteLoader bg= new SpriteLoader(ImageLoader.loadImage("https://raw.githubusercontent.com/Panicode/APCS-Programs/master/etcProjects/littlegame/big%20boy.png"));
        player=sheet.crop(0,0,width,height);
        emptyTile=sheet.crop(0,height*3,width,height);
        standTile=sheet.crop(width,height*3,width,height);
        woodTile=sheet.crop(width*2,height*3,width,height);
        fuelTank=sheet.crop(width*3,height*3,width,height);
        greySlime=sheet.crop(0, height,width,height);
        big=bg.crop(0, 0,117,58);
        small=sm.crop(0, 0,32,32);
    }
}
abstract class State {

    //START STATE MANAGER
    private static State currentState=null;
    public static void setState(State state){
        currentState=state;
    }
    public static State getState(){
        return currentState;
    }
    //END STATE MANAGER

    //Class code
    public abstract void tick();
    public abstract void render(Graphics g);
}
class GameState extends State{
    int x,y;
    boolean xy,yx;
    public GameState(){
        x=0;y=0;xy=true;yx=true;
    }
    @Override
    public void tick() {//640,360
        if(x>=640-117)xy=false;
        if(x<=0)xy=true;
        if(y>=360-58)yx=false;
        if(y<=0)yx=true;
        if(xy){x++;}else{x--;}
        if(yx){y++;}else{y--;}
    }
    @Override
    public void render(Graphics g){
        for(int i=0;i<30;i++){
            for(int j=0;j<15;j++){
                g.drawImage(Assets.small,i*32,j*32,null);
            }
        }
        g.drawImage(Assets.big,x,y,null);
    }
}
