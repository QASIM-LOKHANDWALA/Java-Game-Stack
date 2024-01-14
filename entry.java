import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class entry extends JFrame implements ActionListener{
    
    ImageIcon background = new ImageIcon("Gam.png");
    ImageIcon buttonBackground = new ImageIcon("buttomBack.png");
    JButton ttt = new JButton("TIC TAC TOE");
    JButton snake = new JButton("SNAKE GAME");
    JLabel panel = new JLabel();
    entry(){
        ttt.setBounds(561,399,414,94);
        ttt.setIcon(buttonBackground);
        ttt.addActionListener(this);
        ttt.setFocusable(false);
        ttt.setHorizontalTextPosition(JButton.CENTER);
        ttt.setVerticalTextPosition(JButton.CENTER);
        ttt.setForeground(Color.YELLOW);
        ttt.setBorder(BorderFactory.createLineBorder(Color.white,2));
        ttt.setFont(new Font("sans",Font.BOLD,20));
        
        snake.setBounds(561,526,414,94);
        snake.setIcon(buttonBackground);
        snake.addActionListener(this);
        snake.setFocusable(false);
        snake.setHorizontalTextPosition(JButton.CENTER);
        snake.setVerticalTextPosition(JButton.CENTER);
        snake.setForeground(Color.YELLOW);
        snake.setBorder(BorderFactory.createLineBorder(Color.white,2));
        snake.setFont(new Font("sans",Font.BOLD,20));

        panel.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        panel.setIcon(background);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.add(ttt);
        this.add(snake);
        this.add(panel);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ttt){
            String mes = "1.IT IS A MULTIPLAYER GAME\n2.FIRST TO COMPLETE A LINE WINS\nDO YOU WNAT TO CONTINUE?";
            int a = JOptionPane.showConfirmDialog(this,mes,"INSTRUCION",JOptionPane.YES_OPTION);
            if(a==JOptionPane.YES_OPTION){
                new tick_tack_toe();
            }else{
                new entry();
            }
            
        }
        if(e.getSource()==snake){
            String mes = "1.IT IS A SINGLE PLAYER GAME\n2.USE ARROW KEYS TO TURN\nDO YOU WNAT TO CONTINUE?";
            int a = JOptionPane.showConfirmDialog(this,mes,"INSTRUCION",JOptionPane.YES_OPTION);
            if(a==JOptionPane.YES_OPTION){
                new Game();
            }else{
                new entry();
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
