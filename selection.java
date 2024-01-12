import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class selection extends JFrame implements ActionListener{

    JPanel g1 = new JPanel();
    JPanel g2 = new JPanel();
    selection(){
        g1.setBounds(50,200,100,200);
        g1.setBackground(Color.MAGENTA);
        g1.setOpaque(true);
        
        g2.setBounds(350,200,100,200);
        g2.setBackground(Color.ORANGE);
        g1.setOpaque(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
