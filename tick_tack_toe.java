import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class tick_tack_toe implements ActionListener{
    
    Random r = new Random();
    JFrame f = new JFrame();
    JPanel title = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean p1_turn;
    boolean tie=true;

    tick_tack_toe(){
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        text.setBackground(new Color(25,25,25));
        text.setForeground(Color.GREEN);
        text.setFont(new Font("",Font.BOLD,60));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
        text.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);
        title.add(text);

        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setSize(800,800);
        f.getContentPane().setBackground(new Color(50,50,50));
        f.setLayout(new BorderLayout());

        f.add(title,BorderLayout.NORTH);
        f.add(buttonPanel);
        for(int i=0 ; i<9 ; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.darkGray);
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Comic",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        FirstTurn();

    }
    private void FirstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(r.nextInt(2)==0){
            p1_turn = true;
            text.setText("X Turn");
        }else{
            p1_turn = false;
            text.setText("O Turn");
        }
    }
    private void check(){
        // check x win condition
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
            xWins(0, 1, 2); tie=false;
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
            xWins(3,4,5); tie=false;
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
            xWins(6,7,8); tie=false;
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
            xWins(0, 3, 6); tie=false;
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
            xWins(1,4,7); tie=false;
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
            xWins(2,5,8); tie=false;
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
            xWins(0, 4,8); tie=false;
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
            xWins(2,4,6); tie=false;
        }

        // check o win condition
        if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")){
            oWins(0, 1, 2); tie=false;
        }
        if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
            oWins(3,4,5); tie=false;
        }
        if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
            oWins(6,7,8); tie=false;
        }
        if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
            oWins(0, 3, 6); tie=false;
        }
        if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
            oWins(1,4,7); tie=false;
        }
        if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
            oWins(2,5,8); tie=false;
        }
        if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
            oWins(0, 4,8); tie=false;
        }
        if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
            oWins(2,4,6); tie=false;
        }

        // check the condition for tie
        if((buttons[0].getText()!="")&&
           (buttons[1].getText()!="")&&
           (buttons[2].getText()!="")&&
           (buttons[3].getText()!="")&&
           (buttons[4].getText()!="")&&
           (buttons[5].getText()!="")&&
           (buttons[6].getText()!="")&&
           (buttons[7].getText()!="")&&
           (buttons[8].getText()!="")&&
           (tie)){
            text.setText("TIE");
            for(int i=0 ; i<9 ; i++) buttons[i].setEnabled(false);
        }

    }
    private void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0 ; i<9 ; i++) buttons[i].setEnabled(false);
        text.setText("X WINS");
    }
    private void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0 ; i<9 ; i++) buttons[i].setEnabled(false);
        text.setText("O WINS");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0 ; i<9 ; i++){
            if(e.getSource()==buttons[i]){
                if(p1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        p1_turn = false;
                        text.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("O");
                        p1_turn = true;
                        text.setText("X Turn");
                        check();
                    }
                }
            }
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
