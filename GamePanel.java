import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int BASE_SIZE = 25;
    boolean running = false;
    //Movement variables
    int x = WIDTH/2;
    int y = HEIGHT/2;
    int dx;
    int dy;
    int speed = 5;
    int delay = 16;
    Timer timer;

    public GamePanel() { //constructor to setup the GamePanel object
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); //sets window size
        setBackground(Color.BLACK); //set background color
        setFocusable(true); //allows you to press keys
        addKeyListener(this);
        startGame();
    }
    public void startGame() {
        running = true; //allows game to start running
        timer = new Timer(delay, this); //delay sets game speed
        timer.start(); //starts timer
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(running){
            g.setColor(new Color(255, 230, 150));
            g.fillOval((x)-BASE_SIZE/2, (y)-BASE_SIZE/2, BASE_SIZE, BASE_SIZE);
        }
    }
    public void actionPerformed(ActionEvent e){
        x += dx;
        y += dy;
        repaint();
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            dx = -speed;
            dy = 0;
        }  
        if (key == KeyEvent.VK_RIGHT){
            dx = speed;
            dy = 0;
        } 
        if (key == KeyEvent.VK_UP){
            dy = -speed;
            dx = 0;
        }   
        if (key == KeyEvent.VK_DOWN){
            dy = speed;
            dy = 0;
        }  

        // Update position in game loop
        x += dx * BASE_SIZE;
        y += dy * BASE_SIZE;
    }

}