import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // panel =  canvas inside frame
        GamePanel panel =  new GamePanel();
        JFrame frame = new JFrame();
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //makes user unable to resize window
        frame.add(panel); //adds panel into frame to create game window

        frame.add(panel);   //game panel in the window

        frame.pack();                 //sizes frame to canvas
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true); //shows frame
        panel.requestFocusInWindow();

        panel.startGameThread();
    }
}
