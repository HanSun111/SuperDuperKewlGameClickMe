import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    Image background;
    Image playerIdle;
    //dimensions
    //final int SCALE = 2;
    final int FPS = 60;

    KeyHandler kH = new KeyHandler();

    // game thread
    Thread gameThread;

    Player player = new Player(this, kH);

    //set default position of player
    int x = 950;
    int y = 450;
    int playerSpeed = 5;

    GamePanel() {
        this.setPreferredSize(new Dimension(1900,600));
        background = new ImageIcon("Background/background.png").getImage();
        playerIdle = new ImageIcon("player/Idle.png").getImage();
        this.setDoubleBuffered(true);
        this.addKeyListener(kH);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //broken
        g2.drawImage(background, 0, 0, null);
        //character
        player.draw(g2);
        g2.dispose();
    }

public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
}
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //0.016666666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null){
            long currentTime = System.nanoTime();
            //testing to see if game ran.
            // System.out.println(currentTime);
            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){
        player.update();
    }

}
