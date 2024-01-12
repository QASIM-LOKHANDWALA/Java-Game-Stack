import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class entry extends JFrame implements ActionListener{
    
    ImageIcon background = new ImageIcon("WELCOMETO.png");
    JButton start = new JButton("START");
    JLabel panel = new JLabel();
    entry(){
        start.setBounds(170,320,160,80);
        start.setBackground(Color.BLACK);
        start.addActionListener(this);
        start.setFocusable(false);
        start.setHorizontalTextPosition(JButton.CENTER);
        start.setVerticalTextPosition(JButton.CENTER);
        start.setForeground(Color.YELLOW);
        start.setBorder(BorderFactory.createLineBorder(Color.white,2));
        start.setFont(new Font("MV BOLI",Font.BOLD,20));

        panel.setBounds(0, 0, 500, 500);
        panel.setIcon(background);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setResizable(false);
        this.add(start);
        this.add(panel);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){

        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
