
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GamePanel extends JPanel implements ActionListener{

    JPanel displayScore = new JPanel();
    JLabel scores = new JLabel();
    Border border = BorderFactory.createLineBorder(Color.RED , 2);

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 85;

    final int[] X = new int[GAME_UNITS];
    final int[] Y = new int[GAME_UNITS];

    int body = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean run = false;
    Timer timer;
    Random random;

    GamePanel(){
        scores.setBackground(Color.ORANGE);
        scores.setForeground(Color.BLACK);
        scores.setFont(new Font("Bahnschrift SemiBold SemiConden",Font.BOLD,40));
        scores.setHorizontalAlignment(SwingConstants.CENTER);
        scores.setVerticalAlignment(SwingConstants.CENTER);
        scores.setText("Score: "+applesEaten);

        displayScore.setLayout(new BorderLayout());
        displayScore.setBounds(0,600,SCREEN_HEIGHT,100);
        displayScore.setBackground(Color.ORANGE);
        displayScore.add(scores,BorderLayout.CENTER);

        random = new Random();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,700));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.add(displayScore);

        startGame();

    }
    public void startGame(){
        newApple();
        run = true;
        timer = new Timer(DELAY,this);
        timer.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(run){
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i=0 ; i<body ; i++){
                if (i==0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                }else{
                    g.setColor(new Color(45,180,0));
                    g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            scores.setText("Score: "+applesEaten);
        }else{
            gameOver(g);
        }
    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

    }
    public void move(){
        for(int i=body ; i>0 ; i--){
            X[i] = X[i-1];
            Y[i] = Y[i-1];
        }
        switch (direction) {
            case 'U':
                Y[0] = Y[0]-UNIT_SIZE;
                break;
            case 'D':
                Y[0] = Y[0]+UNIT_SIZE;
                break;
            case 'L':
                X[0] = X[0]-UNIT_SIZE;
                break;    
            case 'R':
                X[0] = X[0]+UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        if(appleX==X[0] && appleY==Y[0]){
            body++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollision(){
        for(int i=body ; i>0 ; i--){
            if((X[0]==X[i])&&(Y[0]==Y[i])){  // checks if head collides with body
                run = false;
            }
        }
        if(X[0]<0){   // checks if body collides with any border
            run = false;
        }
        if( X[0]>SCREEN_WIDTH ){   // checks if body collides with any border
            run = false;
        }
        if(Y[0]<0){   // checks if body collides with any border
            run = false;
        }
        if(Y[0]>SCREEN_HEIGHT){   // checks if body collides with any border
            run = false;
        }
        if(!run){
            timer.stop();
        }
    }
    public void gameOver(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Bahnschrift SemiBold SemiConden",Font.BOLD,75)); //   
        FontMetrics m = getFontMetrics(g.getFont()); 
        g.drawString("Game Over" , (SCREEN_WIDTH - m.stringWidth("Game Over"))/2 , SCREEN_HEIGHT/2 );
        scores.setText("Score: "+applesEaten);
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction!='R') direction='L';
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D') direction='U';
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction!='L') direction='R';
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction!='U') direction='D';
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(run){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }
    
}

