package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class myProfileFrame extends JFrame implements ActionListener{
    JButton exit, play, signOut, search, leaderboard, wrongWord, suddenDeath;
    
    myProfileFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("My Profile");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1040, 585);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        search = new JButton();
        search.setBounds(940, 5, 80, 25);
        search.addActionListener(this);
        search.setText("Search 🔎");
        search.setFocusable(false);
        search.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        search.setBackground(new Color(209, 208, 197));
        search.setBorder(BorderFactory.createEmptyBorder());
        
        signOut = new JButton();
        signOut.setBounds(945, 35, 75, 25);
        signOut.addActionListener(this);
        signOut.setText("Sign Out");
        signOut.setFocusable(false);
        signOut.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        signOut.setBackground(new Color(209, 208, 197));
        signOut.setBorder(BorderFactory.createEmptyBorder());
        
        play = new JButton();
        play.setBounds(740, 5, 90, 25);
        play.addActionListener(this);
        play.setText("Start Game");
        play.setFocusable(false);
        play.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        play.setBackground(new Color(209, 208, 197));
        play.setBorder(BorderFactory.createEmptyBorder());
        
        leaderboard = new JButton();
        leaderboard.setBounds(835, 5, 100, 25);
        leaderboard.addActionListener(this);
        leaderboard.setText("Leaderboard");
        leaderboard.setFocusable(false);
        leaderboard.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        leaderboard.setBackground(new Color(209, 208, 197));
        leaderboard.setBorder(BorderFactory.createEmptyBorder());
        
        wrongWord = new JButton();
        wrongWord.setBounds(870, 485, 125, 35);
        wrongWord.addActionListener(this);
        wrongWord.setText("<html><div style='text-align: center;'>My Top<br>Mispelled Words</div></html>");
        wrongWord.setFocusable(false);
        wrongWord.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        wrongWord.setBackground(new Color(209, 208, 197));
        wrongWord.setBorder(BorderFactory.createEmptyBorder());
        
        suddenDeath = new JButton();
        suddenDeath.setBounds(730, 315, 150, 60);
        suddenDeath.addActionListener(this);
        suddenDeath.setText("<html>Check Sudden<br>Death Score >></html>");
        suddenDeath.setFocusable(false);
        suddenDeath.setFont(new Font("Banana Grotesk", Font.BOLD, 20));
        suddenDeath.setBackground(new Color(53,54,58));
        suddenDeath.setForeground(new Color(97, 99, 102));
        suddenDeath.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(165, 5, 60, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        myProfileInterface myProfileInterface = new myProfileInterface();
        TitleLabel title = new TitleLabel();
        this.add(myProfileInterface.hello);
        this.add(myProfileInterface.allTimeWPM);
        this.add(myProfileInterface.allTimeAccuracy);
        this.add(myProfileInterface.last10WPM);
        this.add(myProfileInterface.last10Accuracy);
        this.add(myProfileInterface.allTime);
        this.add(myProfileInterface.last10);
        this.add(myProfileInterface.suddenDeath);
        this.add(play);
        this.add(signOut);
        this.add(search);
        this.add(leaderboard);
        this.add(wrongWord);
        this.add(suddenDeath);
        this.add(exit);
        this.add(title);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            System.exit(0);
        }
        
        if (e.getSource() == play){
            new gameFrame();
            this.dispose();
        }
        
        if (e.getSource() == signOut){
            signInFrame instance = signInFrame.getInstance();
            instance.setVisible(true);
            signInFrame.username.setText("");
            signInFrame.password.setText("");
            this.dispose();
        }
        
        if (e.getSource() == search){
            otherProfileFrame instance;
            instance = otherProfileFrame.getInstance();
            instance.setVisible(true);
            this.dispose();
        }
        
        if (e.getSource() == leaderboard){
            new leaderboardFrame();
            this.dispose();
        }
        
        if (e.getSource() == wrongWord){
            new myProfileWordFrame();
            this.dispose();
        }
        
        if (e.getSource() == suddenDeath){
            new myProfileSuddenDeath();
            this.dispose();
        }
    }  
}
