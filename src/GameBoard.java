import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameBoard extends JPanel implements ActionListener, KeyListener {
    //init unique GameBoard
    private static GameBoard uniqueInstance;

    public static ArrayList<GameObject> getGameUnits() {
        return gameUnits;
    }

    //Game units
    private static ArrayList<GameObject> gameUnits;
    private static Hero hero;

    //GAME VARIABLES
    final int UNIT_SIZE = 100;
    final static int BOARD_WIDTH = 1217;
    final static int BOARD_HEIGHT = 640;

    //private constructor
    private GameBoard(){
        //Gameboard settings, event listener settings
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    //Init Game
    public static void InitGame(){
        gameUnits = new ArrayList<GameObject>();

        //add hero
        hero = new Hero(0,0, getGameUnits());
        gameUnits.add(hero);

        //add mobs
        //gameUnits.add(new Archer(5,1, getGameUnits()));
        //gameUnits.add(new Assassin(4,4, getGameUnits()));
        gameUnits.add(new Goblin(5,2, getGameUnits()));
        gameUnits.add(new Golem(5,3, getGameUnits()));
        //gameUnits.add(new Knight(8,2, getGameUnits()));
        gameUnits.add(new Warrior(7,3, getGameUnits()));

        //add objects
        gameUnits.add(new Nuke(1,1));
        gameUnits.add(new Tnt(2,2));
        gameUnits.add(new LandMine(2,3));
        gameUnits.add(new HealthKit(1,2));
        gameUnits.add(new HealthKit(1,3));
        gameUnits.add(new MovementBuff(2,4));

    }

    //Get unique instance of GameBoard
    public static GameBoard getInstance() {
        //initiate unique instance if null
        if (uniqueInstance == null) {
            uniqueInstance = new GameBoard();
        }
        return uniqueInstance;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Create new graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));

        //loop all characters and draw them
        for(GameObject c: gameUnits){
            g2.drawImage(c.image, c.xPosition * UNIT_SIZE, c.yPosition * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, null);
        }

        //draw vertical lines
        for(int i=100; i<=BOARD_WIDTH; i+=UNIT_SIZE){
            g2.drawLine(i, 0, i, BOARD_HEIGHT);
        }

        //draw horizontal lines
        for(int i=1; i<=BOARD_WIDTH; i+=UNIT_SIZE){
            g2.drawLine(0, i, BOARD_WIDTH, i);
        }

    }

    //main method
    public static void main(String[] args) throws IOException {
        //Init game
        InitGame();

        //Init JFrame
        JFrame f = new JFrame("Window");

        f.add(getInstance());
        f.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("MOVED");
        repaint();
    }

    public void moveMobs(){
        for(int i=0; i<gameUnits.size(); i++){
            if(!(gameUnits.get(i) instanceof Hero) && (gameUnits.get(i) instanceof Character)){
                ((Character) gameUnits.get(i)).performMove();
            }
        }
        /*for(GameObject c: gameUnits){
            if(!(c instanceof Hero) && (c instanceof Character)){
                ((Character) c).performMove();
            }
        }*/
    }


    public static void writeCharacterPosition(Character c){
        System.out.println(c.getClass().getName() + " is at " + c.xPosition + "," + c.yPosition + ";  ");
    }

    public static void writeCharacterPositionAfterMove(Character c){
        System.out.println(c.getClass().getName() + " moved to " + c.xPosition + "," + c.yPosition);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //get keycode, if it is arrow move the hero
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT) {
            hero.performMove(0);
        }
        else if(code == KeyEvent.VK_RIGHT) {
            hero.performMove(1);
        }
        else if(code == KeyEvent.VK_UP) {
            hero.performMove(2);
        }
        else if(code == KeyEvent.VK_DOWN) {
            hero.performMove(3);
        }

        //move all mobs after hero moved
        moveMobs();

        for(GameObject o: gameUnits){
            if(o instanceof Character){
                System.out.println(o.toString() + " has " + ((Character) o).health);
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void setGameUnits(ArrayList<GameObject> gameUnits) {
        GameBoard.gameUnits = gameUnits;
    }
}

