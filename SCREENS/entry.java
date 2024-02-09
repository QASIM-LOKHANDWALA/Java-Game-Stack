import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class entry extends JFrame implements ActionListener{
    
    static String redColor = " \u001b[31m";
    static String resetColor = "\u001b[37m";
    static boolean isSubscribed = false;
    ImageIcon background = new ImageIcon("images/game stack.png");
    ImageIcon buttonBackground = new ImageIcon("images/buttomBack.png");
    JButton ttt = new JButton("TIC TAC TOE");
    JButton snake = new JButton("SNAKE GAME");
    JButton rpc = new JButton("ROCK PAPER SCISSOR");
    JLabel panel = new JLabel();
    entry(){
        ttt.setBounds(130,474,280,72);
        ttt.setIcon(buttonBackground);
        ttt.addActionListener(this);
        ttt.setFocusable(false);
        ttt.setHorizontalTextPosition(JButton.CENTER);
        ttt.setVerticalTextPosition(JButton.CENTER);
        ttt.setForeground(Color.YELLOW);
        ttt.setBorder(BorderFactory.createLineBorder(Color.white,2));
        ttt.setFont(new Font("sans",Font.BOLD,20));
        
        snake.setBounds(130,552,280,72);
        snake.setIcon(buttonBackground);
        snake.addActionListener(this);
        snake.setFocusable(false);
        snake.setHorizontalTextPosition(JButton.CENTER);
        snake.setVerticalTextPosition(JButton.CENTER);
        snake.setForeground(Color.YELLOW);
        snake.setBorder(BorderFactory.createLineBorder(Color.white,2));
        snake.setFont(new Font("sans",Font.BOLD,20));

        rpc.setBounds(130,630,280,72);
        rpc.setIcon(buttonBackground);
        rpc.addActionListener(this);
        rpc.setFocusable(false);
        rpc.setHorizontalTextPosition(JButton.CENTER);
        rpc.setVerticalTextPosition(JButton.CENTER);
        rpc.setForeground(Color.YELLOW);
        rpc.setBorder(BorderFactory.createLineBorder(Color.white,2));
        rpc.setFont(new Font("sans",Font.BOLD,20));

        panel.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        panel.setIcon(background);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.add(ttt);
        this.add(snake);
        this.add(rpc);
        this.add(panel);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ttt){
            String mes = "1.IT IS A MULTIPLAYER GAME\n2.THE GAME ENDS WHEN EITHER ONE\nOF THE PLAYER FORMS A HORIZONTAL,\nVERTICAL,OR DIAGONAL LINE \nOF THEIR SYMBOL\nOR WHEN THE BOARDIS FULL AND\nTHERE IS NO WINNER\nDO YOU WNAT TO CONTINUE?";
            int a = JOptionPane.showConfirmDialog(this,mes,"INSTRUCION",JOptionPane.YES_OPTION);
            if(a==JOptionPane.YES_OPTION){
                new tick_tack_toe();
            }else{
                return;
            }
            
        }else if(e.getSource()==snake){
            if(isSubscribed){
                String mes = "1.IT IS A SINGLE PLAYER GAME\n2.USE ARROW KEYS TO TURN\n3.IF THE SNAKE TOUCHES ANY EDGE\nOR IT'S OWN BODY GAME ENDS\nDO YOU WNAT TO CONTINUE?";
                int a = JOptionPane.showConfirmDialog(this,mes,"INSTRUCION",JOptionPane.YES_OPTION);
                if(a==JOptionPane.YES_OPTION){
                    new Game();
                }else{
                    return;
                }
            }else{
                new premium();
            }
        }else if(e.getSource()==rpc){
            String mes = "1.IT IS A SINGLE PLAYER GAME\n2.FIRST TO SCORE 5 POINTS WINS\nDO YOU WNAT TO CONTINUE?";
            int a = JOptionPane.showConfirmDialog(this,mes,"INSTRUCION",JOptionPane.YES_OPTION);
            if(a==JOptionPane.YES_OPTION){
                new rpcGame();
            }else{
                return;
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
