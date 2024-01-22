import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class rpcGame extends JFrame implements ActionListener{

    Random random = new Random();

    int playerScore = 0;
    int computerScore = 0;

    String[] choice = {"ROCK","PAPER","SCISSOR"};
    String playerChoice;
    String computer_Choice;

    JButton rock_button = new JButton();
    JButton paper_button = new JButton();
    JButton scissor_button = new JButton();
    JLabel computer = new JLabel();
    JLabel scoreLabel = new JLabel();
    
    Border border = BorderFactory.createLineBorder(Color.BLACK);

    ImageIcon rockIcon = new ImageIcon("rock.png");
    ImageIcon paperIcon = new ImageIcon("paper.png");
    ImageIcon scissorIcon = new ImageIcon("scissor.png");

    JLabel back = new JLabel();
    
    rpcGame(){
        back.setBackground(Color.BLACK);
        back.setOpaque(true);

        computer.setBounds(460,135,100,100);
        computer.setBackground(Color.BLACK);

        scoreLabel.setBounds(252,150,150,60);
        scoreLabel.setBackground(Color.BLACK);
        scoreLabel.setText("0 : 0");
        scoreLabel.setFont(new Font("MV Boli",Font.BOLD,25));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(Color.CYAN);
        scoreLabel.setOpaque(true);

        rock_button.setBounds(40, 25, 175, 100);
        rock_button.setIcon(rockIcon);
        rock_button.setText("ROCK");
        rock_button.setHorizontalTextPosition(JLabel.RIGHT);
        rock_button.setBorder(border);
        rock_button.addActionListener(this);
        rock_button.setFocusable(false);
        rock_button.setOpaque(true);

        paper_button.setBounds(40, 135, 175, 100);
        paper_button.setIcon(paperIcon);
        paper_button.setText("PAPER");
        paper_button.setHorizontalTextPosition(JLabel.RIGHT);
        paper_button.setBorder(border);
        paper_button.addActionListener(this);
        paper_button.setFocusable(false);
        paper_button.setOpaque(true);
        
        scissor_button.setBounds(40, 245, 175, 100);
        scissor_button.setIcon(scissorIcon);
        scissor_button.setText("SCISSOR");
        scissor_button.setHorizontalTextPosition(JLabel.RIGHT);
        scissor_button.setBorder(border);
        scissor_button.addActionListener(this);
        scissor_button.setFocusable(false);
        scissor_button.setOpaque(true);

        this.setTitle("Rock Paper Scissors");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(600,400);
        this.add(rock_button);
        this.add(paper_button);
        this.add(scissor_button);
        this.add(computer);
        this.add(scoreLabel);
        this.add(back);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void checkWin(){
        if(playerChoice.equals("ROCK") && computer_Choice.equals("PAPER")){
            computerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals("ROCK") && computer_Choice.equals("SCISSOR")){
            playerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals("PAPER") && computer_Choice.equals("SCISSOR")){
            computerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals("PAPER") && computer_Choice.equals("ROCK")){
            playerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals("SCISSOR") && computer_Choice.equals("ROCK")){
            computerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals("SCISSOR") && computer_Choice.equals("PAPER")){
            playerScore++;
            scoreLabel.setText(playerScore+" : "+computerScore);
        }else if(playerChoice.equals(computer_Choice)){
            return;
        }
    }
    public void computerChoice(){
        int x = random.nextInt(3);
        switch (x) {
            case 0:
                computer_Choice = choice[0];
                computer.setIcon(rockIcon);
            break;
            case 1:
                computer_Choice = choice[1];
                computer.setIcon(paperIcon);
            break;
            case 2:
                computer_Choice = choice[2];
                computer.setIcon(scissorIcon);
            break;
            default:
            break;
        }
        computer.setOpaque(true);
        checkWin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==rock_button){
            playerChoice = choice[0];
            computerChoice();
        }else if(e.getSource()==paper_button){
            playerChoice = choice[1];
            computerChoice();
        }else if(e.getSource()==scissor_button){
            playerChoice = choice[2];
            computerChoice();
        }
        if(computerScore==5){
            JOptionPane.showMessageDialog(null, "COMPUTER WON", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        }else if(playerScore==5){
            JOptionPane.showMessageDialog(null, "YOU WON", "GAME OVER", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
