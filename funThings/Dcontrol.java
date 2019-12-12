//big yoshi vs. ???

import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
public class Launcher {
    public static void main(String[] args){
        Main game= new Main("TBG",960,540);
        game.start();
    }
}
class Main implements Runnable{ //implements threads
    private Display display;
    public int width, height;
    public String title;

    private boolean running=false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;
    private State settingsState;

    //input
    private KeyManager keyManager;

    public Main(String title,int width,int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();
    }
    private void init(){ //initializing
        display = new Display(title,width,height); //initializes display
        Assets.init(); //asset initialization
        display.getFrame().addKeyListener(keyManager); //input

        gameState=new GameState(this);
        menuState=new MenuState(this);//passes through the `this` statement to define the states
        State.setState(gameState);
    }
    private void tick(){
        keyManager.tick();
        if(State.getState()!=null){ //checks if there's a state active
            State.getState().tick();
        }
        if(((double)getWidth()/(double)getHeight())!=(16.0/9)){
            display.getCanvas().setPreferredSize(new Dimension(getWidth(), (int)(getWidth()/(16.0/9))));
            display.getFrame().pack();
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
        g.clearRect(0,0,getWidth(),getHeight());
        //drawing
        if(State.getState()!=null){
            State.getState().render(g);
        }
        //end drawing
        bs.show();
        g.dispose();
    }
    public void run(){ //The launcher class starts this.
        System.out.println("Loading");
        init(); //initializing the code
        System.out.println("Loading finished");

        int fps = 60;
        double timePerTick = 1000000000/fps;
        /*measured in nanoseconds, divide it by desired FPS to check the wait time before going to another frame.*/
            double delta=0; //instance for the time spent before a frame is drawn
            long now; //instance for the time shown on the running loop
            long lastTime=System.nanoTime();//nanoTime returns the time of a computer in nanoseconds\
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
                System.out.println();
            }
        }
        stop(); //stops the program when the "running" variable is false
    }
    public KeyManager getKeyManager(){//input
        return keyManager;
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
    public int getHeight(){
        return display.getCanvas().getHeight();
    }
    public int getWidth(){
        return display.getCanvas().getWidth();
    }
}



class KeyManager implements KeyListener{
    private boolean[] keys;
    public boolean up,down,left,right;
    public KeyManager(){
        keys=new boolean[256];
    }
    public void tick(){
        up=keys[KeyEvent.VK_W];
        left=keys[KeyEvent.VK_A];
        down=keys[KeyEvent.VK_S];
        right=keys[KeyEvent.VK_D];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
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
        frame.setResizable(true); //resizability
        frame.setLocationRelativeTo(null); //'null' sets it to the middle of the screen
        frame.setVisible(true); //visibility

        //canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height)); //startup size
        canvas.setMaximumSize(new Dimension(width, height)); //minimum size
        canvas.setMinimumSize(new Dimension(width, height)); //maximum size
        canvas.setFocusable(false);

        frame.add(canvas); //adds canvas
        frame.pack(); //packs it to the dimensions
    }
    public Canvas getCanvas(){return canvas;}
    public JFrame getFrame(){return frame;}
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
    protected Main game; //passes through the main code into this, graphics and all
    public State(Main game){ //constructor
        this.game=game;
    }
    //Class code
    public abstract void tick();
    public abstract void render(Graphics g);
}
class GameState extends State{
    private Player player;
    public GameState(Main game){
        super(game);
        player = new Player(game,0,0);
    }
    @Override
    public void tick() {
        player.tick();
    }
    @Override
    public void render(Graphics g){
        player.render(g);
    }
}
class MenuState extends State{
    public MenuState(Main game){
        super(game);
    }
    @Override
    public void tick() {

    }
    @Override
    public void render(Graphics g){

    }
}



class Assets {
    private static final int width=32,height=32; //width and height of each gridspace
    public static BufferedImage big,small;

    public static void init(){
        SpriteLoader bg= new SpriteLoader(ImageLoader.loadImage("https://raw.githubusercontent.com/Panicode/APCS-Programs/master/etcProjects/res/big%20yoshi.png"));
        big=bg.crop(0, 0,128,153);
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



abstract class Entity{
    protected float x,y;

    protected int width,height;
    public Entity(float x,float y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public abstract void tick();
    public abstract void render(Graphics g);


    //getters and setters
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
abstract class Mob extends Entity{

    public static final int DEFAULT_HP=10, DEFAULT_MOB_WIDTH=64, DEFAULT_MOB_HEIGHT=64;
    public static final float DEFAULT_SPEED=15.0f;

    protected int health;
    protected float speed, xMove, yMove;

    public Mob(float x, float y,int width,int height) {
        super(x, y,width,height);
        health=DEFAULT_HP;
        speed=DEFAULT_SPEED;
    }
    public void move(){
        x+=xMove;
        y+=yMove;
    }

    //getters, setters
    public int getHealth() {             //HP
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {            //SPEED
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {            //X MOVE
        return xMove;
    }
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {            //Y MOVE
        return yMove;
    }
    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
class Player extends Mob{
    private Main game;
    public Player(Main game, float x, float y){
        super(x, y, Mob.DEFAULT_MOB_WIDTH, Mob.DEFAULT_MOB_HEIGHT);
        this.game=game;
    }
    @Override
    public void tick() {
        getInput();
        move();
    }
    private void getInput(){
        xMove=0;yMove=0; //sets the moving variable to 0
        if(game.getKeyManager().up)
            yMove=-speed;
        if(game.getKeyManager().left)
            xMove=-speed;
        if(game.getKeyManager().down)
            yMove=+speed;
        if(game.getKeyManager().right)
            xMove=+speed;
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.big,(int)x,(int)y,game.getWidth()/8,game.getHeight()/4,null);
    }
}
