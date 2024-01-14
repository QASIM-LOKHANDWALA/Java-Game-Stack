import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class LoadingScreen extends JFrame{
    
    ImageIcon backImage = new ImageIcon("WELCOME.png");
    JPanel panel = new JPanel();
    JLabel img = new JLabel();
    JProgressBar bar = new JProgressBar();

    LoadingScreen(){
        img.setIcon(backImage);

        panel.add(img);
        panel.setBounds(0, 0, 1536, 864);

        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setBackground(new Color(96,100,0));
        bar.setForeground(new Color(63,20,96));
        bar.setFont(new Font("sans",Font.BOLD,25));
        bar.setBounds(482,421,571,73);

        this.add(bar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);

        fillBar();
    }
    public void fillBar(){
        int x=0;
        while (x<=100) {
            bar.setValue(x);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x++;
        }
    }
}

