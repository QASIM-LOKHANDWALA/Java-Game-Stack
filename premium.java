import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class premium extends JFrame implements ActionListener{

    String[] cardNo = {"4000123456789010","5412751234123456","1234567812345678","1111222233334444"};
    String[] cvvNo = {"555","123","987","111"};
    int noIdx;

    Random random = new Random();

    JButton pay = new JButton("PAY  ₹50");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("BUY PREMIUM");
    JTextField cardNumTextField;
    JTextField cardCvvTextField;
    premium(){

        JLabel cardNum = new JLabel("ENTER CARD NUMBER");
        cardNum.setBounds(40,176,244,34);
        cardNum.setBackground(Color.BLACK);
        cardNum.setForeground(Color.green);
        cardNum.setFont(new Font(null,Font.PLAIN,10));

        cardNumTextField = new JTextField();
        cardNumTextField.setBounds(40,210,340,53);
        cardNumTextField.setFont(new Font(null,Font.BOLD,30));

        JLabel cardCVV = new JLabel("ENTER CVV");
        cardCVV.setBounds(40,300,244,34);
        cardCVV.setBackground(Color.BLACK);
        cardCVV.setForeground(Color.green);
        cardCVV.setFont(new Font(null,Font.PLAIN,10));

        cardCvvTextField = new JTextField();
        cardCvvTextField.setBounds(40,334,340,53);
        cardCvvTextField.setFont(new Font(null,Font.BOLD,30));

        pay.setBounds(210,476,180,56);
        pay.setFocusable(false);
        pay.setBackground(Color.ORANGE);
        pay.setForeground(Color.BLACK);
        pay.addActionListener(this);

        panel.setBounds(0,100,600,500);
        panel.setBackground(Color.DARK_GRAY);

        label.setBounds(0, 0, 600, 100);
        label.setBackground(Color.black);
        label.setForeground(Color.GREEN);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Consolas",Font.BOLD,60));

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(600,600);
        this.setLayout(null);
        this.add(cardNum);
        this.add(cardNumTextField);
        this.add(cardCVV);
        this.add(cardCvvTextField);
        this.add(pay);
        this.add(panel);
        this.add(label);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==pay){
            String enterdnum = cardNumTextField.getText();
            System.out.println(enterdnum);
            boolean cNum = checkNum(enterdnum);
            System.out.println(cNum);
            String enterdcvv = cardCvvTextField.getText();
            System.out.println(enterdcvv);
            boolean cCvv = checkCvv(enterdcvv);
            System.out.println(cCvv);
            if (cCvv && cNum) {
                int otp = 1000+random.nextInt(10000);
                JOptionPane.showMessageDialog(null,"YOUR OTP IS : "+otp,"VERIFY",JOptionPane.PLAIN_MESSAGE);
                String getOtp = JOptionPane.showInputDialog(null, "ENTER OTP");
                if(otp == Integer.parseInt(getOtp)){
                    this.dispose();
                    JOptionPane.showMessageDialog(null,"PAYMENT SUCCESSFUL","SUCCESSFUL",JOptionPane.PLAIN_MESSAGE);
                    entry.isSubscribed=true;
                }else{
                    this.dispose();
                    JOptionPane.showMessageDialog(null,"INVALID OTP","ERROR",JOptionPane.ERROR_MESSAGE);
                    new premium();
                }
            }else{
                this.dispose();
                JOptionPane.showMessageDialog(null,"INVALID CARD NUMBER OR CVV","ERROR",JOptionPane.ERROR_MESSAGE);
                new premium();
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public boolean checkNum(String num){
        for (int i=0 ; i<4 ; i++) {
            if(num.equals(cardNo[i])){
                noIdx=i;
                return true;
            }
        }
        return false;
    }
    public boolean checkCvv(String num){
        if(num.equals(cvvNo[noIdx])){
            return true;
        }else{
            return false;
        }
        
    }
}
