import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int WIDTH = 800;
    final int HEIGHT = 500;
    final int playerSizeX = 20;
    final int playerSizeY = 75;
    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set players defualt position
    int playerX = 25;
    double playerY = 100;
    double playerSpeed = .5;

    // setup enemy variables
    int enemyX = WIDTH - 25;
    double enemyY = 100;
    double enemySpeed = .5;

    public GamePanel(){ //controls gamepanel within the window
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //smooths graphics with no buffer
        this.addKeyListener(keyH); //adds listeners for keys
        this.setFocusable(true); //controls whether a component can receive keyboard input

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 100000000/FPS; //0.01666667 seconds
        double nextDrawTime = System.nanoTime() + drawInterval; //returns java built in timer

        while(gameThread != null){

            //Update character positions
            update();
            //draw the screen with updated info
            repaint();
            
            //controls FPS
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public void update(){
        System.out.println(playerY);
        if(playerY > 0 && playerY < (500 - playerSizeY)) {
            if(keyH.upPressed == true){
                playerY -= playerSpeed;
            }
            else if(keyH.downPressed == true){
                playerY += playerSpeed;
            }
        }
        else if(playerY <= 0){
            playerY = 1;
        }
        else if(playerY >= (500 - playerSizeY)){
            playerY = (500 - playerSizeY);
        }

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //extends graphics class to provide better control over coordinates, layout, etc
        g2.setColor(Color.white);
        g2.fillRect(playerX, (int)playerY, playerSizeX, playerSizeY);//create player
        g2.fillRect(enemyX, (int)enemyY, playerSizeX, playerSizeY);//create player
        g2.dispose(); //helps with memory not necessary
    }

}
