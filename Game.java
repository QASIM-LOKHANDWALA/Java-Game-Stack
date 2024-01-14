
import javax.swing.JFrame;

public class Game extends JFrame{

    Game(){


        GamePanel panel = new GamePanel();

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Snake");
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}

