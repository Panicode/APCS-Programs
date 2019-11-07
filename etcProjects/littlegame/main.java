/*
Tetris Applet
by Melinda Green
based on Guido Pellegrini's Summer 2000 term project

Use this code for anything you like.
If you use it in a mission critical application and
a bug in this code causes a global nuclear war, I will
take full responsibility and will fix the bug for free.
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;
import java.net.URL;
import java.net.MalformedURLException;

public class Tetris extends Applet {

    //
    // STATIC MEMBERS
    //

    private final static int INITIAL_DELAY = 1000;
    private final static byte ROWS = 18;
    private final static byte COLUMNS = 10;
    private final static int EMPTY = -1;
    private final static int DELETED_ROWS_PER_LEVEL = 5;
    private final static Color PIECE_COLORS[] = {
            new Color(0xFF00FF), // fucia
            new Color(0xDC143C), // crimson
            new Color(0x00CED1), // dark turquoise
            new Color(0xFFD700), // gold
            new Color(0x32CD32), // lime green
            new Color(0x008080), // teal
            new Color(0xFFA500), // orange
    };
    private final static Color BACKGROUND_COLORS[] = {
            new Color(0xFFDAB9), // peachpuff
            new Color(0xFFC0CB), // pink
            new Color(0xFF99CC), // hot pink
            new Color(0x0099CC), // sky blue
            new Color(0x9966CC), // lavender
    };
    private final static Color BACKGROUND_COLOR = new Color(0x99FFCC);

    //   *    **   *    *    *    *
    //   *    *    *    **   **   **   **
    //   *    *    **    *   *    *    **
    //   *
    //   0    1    2    3    4    5    6
    private final static boolean PIECE_BITS[][][] = {
            {
                    {false, true, false, false},
                    {false, true, false, false},
                    {false, true, false, false},
                    {false, true, false, false},
            },
            {
                    {false, false, false, false},
                    {false, true, true, false},
                    {false, true, false, false},
                    {false, true, false, false},
            },
            {
                    {false, false, false, false},
                    {false, true, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
            },
            {
                    {false, false, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
                    {false, false, true, false},
            },
            {
                    {false, false, false, false},
                    {false, false, true, false},
                    {false, true, true, false},
                    {false, true, false, false},
            },
            {
                    {false, false, false, false},
                    {false, true, false, false},
                    {false, true, true, false},
                    {false, true, false, false},
            },
            {
                    {false, false, false, false},
                    {false, false, false, false},
                    {false, true, true, false},
                    {false, true, true, false},
            },
    };
    private static boolean tmp_grid[][] = new boolean[4][4]; // scratch space
    private static Random random = new Random();

    private static class TetrisLabel extends Label {
        private final static Font LABEL_FONT = new Font("Serif", Font.BOLD, 18);
        private TetrisLabel(String text) {
            super(text);
            setFont(LABEL_FONT);
        }
        private void addValue(int val) {
            setText(Integer.toString((Integer.parseInt(getText())) + val ));
        }
    }

    //
    // INSTANCE DATA
    //

    private int grid[][] = new int[ROWS][COLUMNS];
    private int next_piece_grid[][] = new int[4][4];
    private int num_rows_deleted = 0;
    private GridCanvas game_grid = new GridCanvas(grid, true);
    private GridCanvas next_piece_canvas = new GridCanvas(next_piece_grid, false);
    private Timer timer;
    private TetrisPiece cur_piece;
    private TetrisPiece next_piece = randomPiece();
    private TetrisSound sounds;// = new TetrisSound(this);
    private TetrisLabel rows_deleted_label = new TetrisLabel("0");
    private TetrisLabel level_label = new TetrisLabel("1");
    private TetrisLabel score_label = new TetrisLabel("0");
    private TetrisLabel high_score_label = new TetrisLabel("");
    final Button start_newgame_butt = new TetrisButton("Start");
    final Button pause_resume_butt = new TetrisButton("Pause");

    //
    // INNER CLASSES
    //

    private class TetrisButton extends Button {
        public TetrisButton(String label) {
            super(label);
        }
        public Dimension getPreferredSize() {
            return new Dimension(120, super.getPreferredSize().height);
        }
    }

    private class TetrisPiece {
        private boolean squares[][];
        private int type;
        private Point position = new Point(3, -4); // -4 to start above top row
        public int getX() { return position.x; }
        public int getY() { return position.y; }
        public void setX(int newx) { position.x = newx; }
        public void setY(int newy) { position.y = newy; }
        public void setPosition(int newx, int newy) { setX(newx); setY(newy); }

        public TetrisPiece(int type) {
            this.type = type;
            this.squares = new boolean[4][4];
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    this.squares[i][j] = PIECE_BITS[type][i][j];
        }

        public boolean canStepDown() {
            synchronized(timer) {
                cut();
                position.y++;
                boolean OK = canPaste();
                position.y--;
                paste();
                return OK;
            }
        }

        public boolean canPaste() {
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    int to_x = j + position.x;
                    int to_y = i + position.y;
                    if(squares[i][j]) { // piece contains this square?
                        if(0 > to_x || to_x >= COLUMNS // square too far left or right?
                                || to_y >= ROWS) // square off bottom?
                        {
                            return false;
                            // note: it's always considered OK to paste a square
                            // *above* the grid though attempting to do so does nothing.
                            // This allows the user to move a piece before it drops
                            // completely into view.
                        }
                        if(to_y >= 0 && grid[to_y][to_x] != EMPTY)
                            return false;
                    }
                }
            }
            return true;
        }

        public void stepDown() {
            position.y++;
        }

        public void cut() {
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    if(squares[i][j] && position.y+i>=0)
                        grid[position.y + i][position.x + j] = EMPTY;
        }

        /**
         * Paste the color info of this piece into the given grid
         */
        public void paste(int into[][]) {
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    if(squares[i][j] && position.y+i>=0)
                        into[position.y + i][position.x + j] = type;
        }

        /**
         * No argument version assumes pasting into main game grid
         */
        public void paste() {
            paste(grid);
        }

        public void rotate() {
            // copy the piece's data into a temp array
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    tmp_grid[i][j] = squares[i][j];
            // copy back rotated 90 degrees
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    squares[j][i] = tmp_grid[i][3-j];
        }
        public void rotateBack() {
            // copy originally saved version back
            // this of course assumes this call was preceeded by
            // a call to rotate() for the same piece
            for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    squares[i][j] = tmp_grid[i][j];
        }

        // this method is a bit of a hack to check for the case
        // where a piece may be safely on the grid but have one or more
        // rows of empty squares that are above the grid and therefore OK
        public boolean isTotallyOnGrid() {
            for(int i=0; i<4; i++) {
                if(position.y + i >= 0)
                    return true; //everything from here down is on grid
                // this row is above grid so look for non-empty squares
                for(int j=0; j<4; j++)
                    if(squares[i][j])
                        return false;
            }
            System.err.println("TetrisPiece.isTotallyOnGrid internal error");
            return false;
        }
    } // end class TetrisPiece


    private class Timer extends Thread {
        private long m_delay;
        private boolean m_paused = true;
        private boolean m_fast = false;
        private ActionListener m_cb;
        public Timer(long delay, ActionListener cb) {
            setDelay(delay);
            m_cb = cb;
        }
        public void setPaused(boolean pause) {
            m_paused = pause;
            if(m_paused) {
                sounds.stopSoundtrack();
            }
            else {
                sounds.playSoundtrack();
                synchronized(this) {
                    this.notify();
                }
            }
        }
        public boolean isPaused() { return m_paused; }
        public void setDelay(long delay) { m_delay = delay; }
        public boolean isRunning() { return !m_paused; }
        public void setFast(boolean fast) {
            m_fast = fast;
            if(m_fast) {
                try {
                    this.checkAccess();
                    this.interrupt(); // no exception, so OK to interrupt
                } catch(SecurityException se) {}
            }
        }
        public boolean isFast() { return m_fast; }
        public void faster() {
            m_delay = (int)(m_delay * .9); //increase the speed exponentially in reverse
        }
        public void run() {
            while(true) {
                try {
                    sleep(m_fast ? 30 : m_delay);
                } catch (Exception e) {}
                if(m_paused) {
                    try {
                        synchronized(this) {
                            this.wait();
                        }
                    } catch(InterruptedException ie) {}
                }
                synchronized(this) {
                    m_cb.actionPerformed(null);
                }
            }
        }
    } // end class Timer

    private class GridCanvas extends DoubleBufferedCanvas {
        private int grid[][];
        private boolean paint_background;
        public GridCanvas(int[][] grid, boolean do_background) {
            this.grid = grid;
            paint_background = do_background;
            clear();
        }

        private void clear() {
            for(int i=0; i<grid.length; i++)
                for(int j=0; j<grid[0].length; j++)
                    grid[i][j] = EMPTY;
        }
        public Dimension getPreferredSize() {
            return new Dimension(grid[0].length * 30, grid.length * 30);
        }
        public void paint(Graphics g) {
            g = this.startPaint(g); // returned g paints into offscreen image
            int width = this.getSize().width;
            int height = this.getSize().height;
            g.clearRect(0, 0, width, height);
            int cell_size, xstart, ystart;
            double panel_aspect_ratio = (double)width/height;
            double grid_aspect_ratio = (double)grid[0].length/grid.length;
            if(panel_aspect_ratio > grid_aspect_ratio) {
                // extra space on sides
                cell_size = (int)((double)height/grid.length + 0.5);
                xstart = (int)(width/2 - (grid[0].length/2.0 * cell_size + 0.5));
                ystart = 0;
            }
            else {
                // extra vertical space
                cell_size = (int)((double)width/grid[0].length + 0.5);
                xstart = 0;
                ystart = (int)(height/2 - (grid.length/2.0 * cell_size + 0.5));
            }
            if(paint_background) {
                g.setColor(BACKGROUND_COLORS[(num_rows_deleted / DELETED_ROWS_PER_LEVEL) % BACKGROUND_COLORS.length]);
                g.fillRect(xstart, ystart, COLUMNS*cell_size, ROWS*cell_size);
            }
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] != EMPTY) {
                        g.setColor(PIECE_COLORS[grid[i][j]]);
                        int x = xstart + j*cell_size;
                        int y = ystart + i*cell_size;
                        g.fill3DRect(x, y, cell_size, cell_size, true);
                    }
                }
            }
            this.endPaint(); // paints accumulated image in one shot
        }
    } // end class GridCanvas

    private class TetrisSound {
        private AudioClip soundTrack = null;
        private AudioClip destroyRowSounds[] = new AudioClip[4];
        private AudioClip gameOverSound = null;
        private AudioClip getClip(String name) throws MalformedURLException {
            URL soundFileUrl = new URL(getCodeBase(), name);
            try {
                AudioClip clip = getAudioClip(soundFileUrl);
                return clip;
            } catch(NullPointerException npe) {
                System.err.println("exception " + npe);
                return null;
            }
        }
        public TetrisSound() {
            //load sound files
            try {
                soundTrack          = getClip("theme.au");
                destroyRowSounds[0] = getClip("quiteImpressive.au");
                destroyRowSounds[1] = getClip("smashing.au");
                destroyRowSounds[2] = getClip("yeahbaby.au");
                destroyRowSounds[3] = getClip("great.au");
                gameOverSound       = getClip("groovy.au");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        public void playSoundtrack() {
            if(soundTrack == null)
                return;
            soundTrack.loop();
        }
        public void playDestroyRows(int rows) {
            int soundid = rows - 1;
            if(0 > soundid || soundid >= destroyRowSounds.length || destroyRowSounds[soundid] == null)
                return;
            destroyRowSounds[soundid].play();
        }
        public void playGameOverSound() {
            if(gameOverSound == null)
                return;
            gameOverSound.play();
        }
        public void stopSoundtrack() {
            if(soundTrack == null)
                return;
            soundTrack.stop();
        }
    } // end class TetrisSound


    //
    // INSTANCE METHODS
    //

    private TetrisPiece randomPiece() {
        int rand = Math.abs(random.nextInt());
        return new TetrisPiece(rand % (PIECE_COLORS.length));
    }

    private void installNewPiece() {
        next_piece_canvas.clear();
        cur_piece = next_piece;
        cur_piece.setPosition(3, -4); //-4 to start above top of grid
        if(cur_piece.canPaste()) {
            next_piece = randomPiece();
            next_piece.setPosition(0, 0);
            next_piece.paste(next_piece_grid);
            next_piece_canvas.repaint();
        }
        else
            gameOver();
    }

    private void gameOver() {
        System.out.println("Game Over!");
        timer.setPaused(true);
        pause_resume_butt.setEnabled(false);
        int score = Integer.parseInt(score_label.getText());
        int high_score = high_score_label.getText().length() > 0 ?
                Integer.parseInt(high_score_label.getText()) : 0;
        if(score > high_score)
            high_score_label.setText("" + score);
        sounds.playGameOverSound();
    }

    private boolean rowIsFull(int row) {
        for(int i=0; i<COLUMNS; i++)
            if(grid[row][i] == EMPTY)
                return false;
        return true;
    }

    private int countFullRows() {
        int n_full_rows = 0;
        for(int i=0; i<ROWS; i++)
            if(rowIsFull(i))
                n_full_rows++;
        return n_full_rows;
    }

    private void removeRow(int row) {
        for(int j=0; j<COLUMNS; j++)
            grid[row][j] = EMPTY;
        for(int i=row; i>0; i--) {
            for(int j=0; j<COLUMNS; j++) {
                grid[i][j] = grid[i-1][j];
            }
        }
    }

    private void removeFullRows() {
        int n_full = countFullRows();
        score_label.addValue((int)(10 * Math.pow(2, n_full) - 10)); //give points exponentially
        if(n_full == 0)
            return;
        sounds.playDestroyRows(n_full);
        if(num_rows_deleted / DELETED_ROWS_PER_LEVEL != (num_rows_deleted+n_full) / DELETED_ROWS_PER_LEVEL) {
            timer.faster();
            level_label.addValue(n_full / DELETED_ROWS_PER_LEVEL + 1);
            level_label.repaint();
        }
        rows_deleted_label.addValue(n_full);
        num_rows_deleted += n_full;
        for(int i=ROWS-1; i>=0; i--)
            while(rowIsFull(i))
                removeRow(i);
        game_grid.repaint();
    }

    public void start() {
        timer = new Timer(INITIAL_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                synchronized(timer) {
                    if(cur_piece.canStepDown()) {
                        cur_piece.cut();
                        cur_piece.stepDown();
                        cur_piece.paste();
                        if(timer.isFast())
                            score_label.addValue(1); // a small reward for using fast mode
                    }
                    else { // it hit something
                        timer.setFast(false);
                        if( ! cur_piece.isTotallyOnGrid())
                            gameOver();
                        else {
                            removeFullRows();
                            installNewPiece();
                        }
                    }
                }
                game_grid.repaint();
            }
        });
        timer.start(); // pauses immediately
    }

    public void stop() {
        pauseGame();
        synchronized(timer){
            timer.stop();
        }
        timer = null;
    }

    private void startGame() {
        timer.setDelay(INITIAL_DELAY);
        timer.setPaused(false);
        start_newgame_butt.setLabel("Start New Game");
        pause_resume_butt.setEnabled(true); // stays enabled from here on
        pause_resume_butt.setLabel("Pause");
        pause_resume_butt.validate();
        sounds.playSoundtrack();
    }

    private void newGame() {
        game_grid.clear();
        installNewPiece();
        num_rows_deleted = 0;
        rows_deleted_label.setText("0");
        level_label.setText("1");
        score_label.setText("0");
        startGame();
    }

    private void pauseGame() {
        timer.setPaused(true);
        pause_resume_butt.setLabel("Resume");
        sounds.stopSoundtrack();
    }

    private void resumeGame() {
        timer.setPaused(false);
        pause_resume_butt.setLabel("Pause");
        sounds.playSoundtrack();
    }

    public void init() {
        sounds = new TetrisSound(); // NOTE: Must be initialized after Applet fully constructed!
        installNewPiece();

        pause_resume_butt.setEnabled(false);
        start_newgame_butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(start_newgame_butt.getLabel().equals("Start"))
                    startGame();
                else
                    newGame();
            }
        });
        pause_resume_butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(pause_resume_butt.getLabel().equals("Pause"))
                    pauseGame();
                else
                    resumeGame();
            }
        });

        //create key listener for rotating, moving left, moving right
        KeyListener key_listener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(timer.isPaused()) //don't do anything if game is paused
                    return;
                if (e.getKeyCode() == 37 || e.getKeyCode() == 39) { //left or right arrow pressed
                    int dir = e.getKeyCode() == 37 ? -1 : 1;
                    synchronized(timer) {
                        cur_piece.cut();
                        cur_piece.setX(cur_piece.getX() + dir); // try to move
                        if( ! cur_piece.canPaste())
                            cur_piece.setX(cur_piece.getX() - dir); // undo move
                        cur_piece.paste();
                    }
                    game_grid.repaint();
                }
                else if (e.getKeyCode() == 38) { //rotate
                    synchronized(timer) {
                        cur_piece.cut();
                        cur_piece.rotate();
                        if( ! cur_piece.canPaste())
                            cur_piece.rotateBack();
                        cur_piece.paste();
                    }
                    game_grid.repaint();
                }
                if (e.getKeyCode() == 40) { //down arrow pressed; drop piece
                    timer.setFast(true);
                }
            }
        };

        // add the key listener to all components that might get focus
        // so that it'll work regardless of which has focus
        start_newgame_butt.addKeyListener(key_listener);
        pause_resume_butt.addKeyListener(key_listener);

        Panel right_panel = new Panel(new GridLayout(3, 1));
        right_panel.setBackground(BACKGROUND_COLOR);

        Panel control_panel = new Panel();
        control_panel.add(start_newgame_butt);
        control_panel.add(pause_resume_butt);
        control_panel.setBackground(BACKGROUND_COLOR);
        right_panel.add(control_panel);

        Panel tmp = new Panel(new BorderLayout());
        tmp.add("North", new TetrisLabel("    Next Piece:"));
        tmp.add("Center", next_piece_canvas);
        tmp.setBackground(BACKGROUND_COLOR);
        right_panel.add(tmp);

        Panel stats_panel = new Panel(new GridLayout(4, 2));
        stats_panel.add(new TetrisLabel("    Rows Deleted: "));
        stats_panel.add(rows_deleted_label);
        stats_panel.add(new TetrisLabel("    Level: "));
        stats_panel.add(level_label);
        stats_panel.add(new TetrisLabel("    Score: "));
        stats_panel.add(score_label);
        stats_panel.add(new TetrisLabel("    High Score: "));
        stats_panel.add(high_score_label);
        tmp = new Panel(new BorderLayout());
        tmp.setBackground(BACKGROUND_COLOR);
        tmp.add("Center", stats_panel);
        right_panel.add(tmp);

        // finaly, add all the main panels to the applet panel
        this.setLayout(new GridLayout(1, 2));
        this.add(game_grid);
        this.add(right_panel);
        this.setBackground(BACKGROUND_COLOR);
        this.validate();
    }


    public static void main(String[] args) {

        Frame frame = new Frame("Tetris");
        Tetris tetris = new Tetris();
        frame.add(tetris);
        tetris.init();
        tetris.start();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(489, 441);
        frame.setResizable(false);
        frame.setVisible(true);
    }
} // end class Tetris


class DoubleBufferedCanvas extends Canvas {
    private Image mActiveOffscreenImage = null;
    private Dimension mOffscreenSize = new Dimension(-1,-1);
    private Graphics mActiveOffscreenGraphics = null;
    private Graphics mSystemGraphics = null;

    DoubleBufferedCanvas() {
		/*
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		});*/
    }

    /**
     * NOTE: when extending applets:
     * this overrides update() to *not* erase the background before painting
     */
    public void update(Graphics g) {
        paint(g);
    }

    public Graphics startPaint (Graphics sysgraph) {
        mSystemGraphics = sysgraph;
        // Initialize if this is the first pass or the size has changed
        Dimension d = getSize();
        if ((mActiveOffscreenImage == null) ||
                (d.width != mOffscreenSize.width) ||
                (d.height != mOffscreenSize.height))
        {
            mActiveOffscreenImage = createImage(d.width, d.height);
            mActiveOffscreenGraphics = mActiveOffscreenImage.getGraphics();
            mOffscreenSize = d;
            mActiveOffscreenGraphics.setFont(getFont());
        }
        //mActiveOffscreenGraphics.clearRect(0, 0, mOffscreenSize.width, mOffscreenSize.height);
        return mActiveOffscreenGraphics;
    }

    public void endPaint () {
        // Start copying the offscreen image to this canvas
        // The application will begin drawing into the other one while this happens
        mSystemGraphics.drawImage(mActiveOffscreenImage, 0, 0, null);
    }
}
