import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class entry extends JFrame implements ActionListener{
    
    ImageIcon background = new ImageIcon("WELCOMETO.png");
    JButton ttt = new JButton("TIC TAC TOE");
    JButton snake = new JButton("SNAKE GAME");
    JLabel panel = new JLabel();
    entry(){
        ttt.setBounds(170,220,160,80);
        ttt.setIcon(background);
        ttt.setBackground(new Color(17,21,33,30));
        ttt.addActionListener(this);
        ttt.setFocusable(false);
        ttt.setHorizontalTextPosition(JButton.CENTER);
        ttt.setVerticalTextPosition(JButton.CENTER);
        ttt.setForeground(Color.YELLOW);
        ttt.setBorder(BorderFactory.createLineBorder(Color.white,2));
        ttt.setFont(new Font("sans",Font.BOLD,20));
        
        snake.setBounds(170,310,160,80);
        snake.setIcon(background);
        snake.setBackground(new Color(17,21,33,30));
        snake.addActionListener(this);
        snake.setFocusable(false);
        snake.setHorizontalTextPosition(JButton.CENTER);
        snake.setVerticalTextPosition(JButton.CENTER);
        snake.setForeground(Color.YELLOW);
        snake.setBorder(BorderFactory.createLineBorder(Color.white,2));
        snake.setFont(new Font("sans",Font.BOLD,20));

        panel.setBounds(0, 0, 500, 500);
        panel.setIcon(background);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setResizable(false);
        this.add(ttt);
        this.add(snake);
        this.add(panel);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ttt){
            new tick_tack_toe();
        }
        if(e.getSource()==snake){
            new Game();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
