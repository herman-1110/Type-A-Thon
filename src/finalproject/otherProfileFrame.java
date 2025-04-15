package finalproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class otherProfileFrame extends JFrame implements ActionListener{
    JTextField searchUser;
    JButton search, back, exit, wrongWord, suddenDeath;
    otherProfileInterface otherProfileInterface = new otherProfileInterface(null);
    otherProfileMessage getMessage;
    private static otherProfileFrame otherProfileFrame;
    otherProfileWordFrame otherProfileWordFrame;
    otherProfileSuddenDeath otherProfileSuddenDeath;
    
    otherProfileFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("Search Profile");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1040, 585);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        searchUser = new JTextField();
        searchUser.setBounds(390, 5, 250, 25);
        searchUser.setPreferredSize(new Dimension(250, 25));
        searchUser.setFont(new Font("Banana Grotesk", Font.PLAIN, 15));
        searchUser.setForeground(new Color(226, 183, 20));
        searchUser.setBackground(new Color(44, 46, 49));
        searchUser.setCaretColor(new Color(226, 183, 20));
        searchUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        search = new JButton();
        search.setBounds(660, 5, 80, 25);
        search.addActionListener(this);
        search.setText("Search 🔎");
        search.setFocusable(false);
        search.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        search.setBackground(new Color(209, 208, 197));
        search.setBorder(BorderFactory.createEmptyBorder());
        
        wrongWord = new JButton();
        wrongWord.setBounds(870, 485, 125, 35);
        wrongWord.addActionListener(this);
        wrongWord.setText("<html><div style='text-align: center;'>Top Mispelled<br>Words</div></html>");
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
        
        back = new JButton();
        back.setBounds(960, 5, 60, 25);
        back.addActionListener(this);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        back.setBackground(new Color(209, 208, 197));
        back.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(165, 5, 60, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        TitleLabel title = new TitleLabel();
        this.add(title);
        this.add(otherProfileInterface.search);
        this.add(searchUser);
        this.add(search);
        this.add(back);
        this.add(exit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search){
            
            otherProfileInterface = new otherProfileInterface(searchUser.getText().trim());
            Component[] components = this.getContentPane().getComponents();
            
            for (Component comp : components) {
                if (comp instanceof otherProfileMessage){
                    this.remove(comp);
                }
            }
            
            try {
                if (database.readDatabase(searchUser.getText(), null)){
                    for (Component comp : components) {
                        if (comp instanceof JLabel){
                            this.remove(comp);
                        }
                    }
                    addComponent();
                    otherProfileWordFrame.setVisible(false);
                    otherProfileSuddenDeath.setVisible(false);
                    searchUser.setText("");
                    revalidate();
                    repaint();
                }
                else {
                    this.add(getMessage = new otherProfileMessage());
                    revalidate();
                    repaint();
                }
            } catch (Exception f){
            }
        }

        if (e.getSource() == back){
            new myProfileFrame();
            this.dispose();
        }
        
        if (e.getSource() == wrongWord){
            otherProfileWordFrame.setVisible(true);
            this.setVisible(false);
        }
        
        if (e.getSource() == suddenDeath){
            otherProfileSuddenDeath.setVisible(true);
            this.setVisible(false);
        }
        
        if (e.getSource() == exit){
            System.exit(0);
        }
    }
    
    public void addComponent(){
        TitleLabel title = new TitleLabel();
        this.add(title);
        this.add(otherProfileInterface.search);
        this.add(otherProfileInterface.allTime);
        this.add(otherProfileInterface.last10);
        this.add(otherProfileInterface.sProfile);
        this.add(otherProfileInterface.allTimeWPM);
        this.add(otherProfileInterface.allTimeAccuracy);
        this.add(otherProfileInterface.last10WPM);  
        this.add(otherProfileInterface.last10Accuracy);
        this.add(otherProfileInterface.suddenDeath);
        this.add(wrongWord);
        this.add(suddenDeath);
        otherProfileSuddenDeath = new otherProfileSuddenDeath(searchUser.getText().trim());
        otherProfileWordFrame = new otherProfileWordFrame(searchUser.getText().trim());
    }
    
    public static otherProfileFrame getInstance() {
        if (otherProfileFrame == null){
            otherProfileFrame = new otherProfileFrame();
        }
        return otherProfileFrame;
    }
}
