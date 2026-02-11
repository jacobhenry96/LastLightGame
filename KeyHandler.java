import java.awt.event.*;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // Called when a key is typed (pressed and released)
        //needs to be here for code to run but will not be used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Called when a key is pressed
        int code = e.getKeyCode();
        
        // if(code == KeyEvent.VK_W){
        //     upPressed = true;
        // }
        // if(code == KeyEvent.VK_S){
        //     downPressed = true;
        // }
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Called when a key is released
        int code = e.getKeyCode();

        // if(code == KeyEvent.VK_W){
        //     upPressed = false;
        // }
        // if(code == KeyEvent.VK_S){
        //     downPressed = false;
        // }
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
    }
}
