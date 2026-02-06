import javax.swing.JFrame;

public class LastLight {

    public static void main(String[] args) {
        // panel =  canvas inside frame
        JFrame frame = new JFrame("Last Light");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(new GamePanel());   //game panel in the window

        frame.pack();                 //sizes frame to canvas
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true); //shows frame
    }
}
