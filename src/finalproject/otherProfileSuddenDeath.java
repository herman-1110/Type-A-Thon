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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class otherProfileSuddenDeath extends JFrame implements ActionListener{
    JButton exit, back;
    JLabel suddenDeath, info;
    JPanel background;
    otherProfileSuddenDeathInterface otherProfileSuddenDeathInterface;
    
    otherProfileSuddenDeath(String username){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100  , Image.SCALE_SMOOTH));
        ImageIcon logo = new ImageIcon(new ImageIcon("typeathon1.jpg").getImage().getScaledInstance(95,95  , Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("Sudden Death Score");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 690);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        suddenDeath = new JLabel();
        suddenDeath.setBounds(140, 50, 600, 80);
        suddenDeath.setText("<html><div style='text-align: center;'>His/Her Sudden<br>Death Score</div></html>");
        suddenDeath.setForeground(new Color(226, 183, 20));
        suddenDeath.setFont(new Font("Banana Grotesk", Font.BOLD, 26));
        suddenDeath.setLayout(null);
        
        info = new JLabel();
        info.setBounds(40, 155, 390, 80);
        info.setText("#                                             WPM");
        info.setForeground(new Color(97, 99, 102));
        info.setBackground(new Color(53, 54, 58));
        info.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        info.setLayout(null);
        
        background = new JPanel();
        background.setBackground(new Color(44, 46, 49));
        background.setBounds(15, 215, 305, 420);
        background.setLayout(null);
        
        back = new JButton();
        back.setBounds(270, 5, 60, 25);
        back.addActionListener(this);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        back.setBackground(new Color(209, 208, 197));
        back.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(135, 5, 50, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        TitleLabel title = new TitleLabel();
        title.setBounds(5, 5, 130, 150);
        title.setIconTextGap(10);
        title.setIcon(logo);
        otherProfileSuddenDeathInterface = new otherProfileSuddenDeathInterface(username);
        this.add(title);
        this.add(otherProfileSuddenDeathInterface.listScroll);
        this.add(background);
        this.add(suddenDeath);
        this.add(info);
        this.add(back);
        this.add(exit);
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            otherProfileFrame instance;
            instance = otherProfileFrame.getInstance();
            instance.setVisible(true);
            this.setVisible(false);
        }
        
        if (e.getSource() == exit){
            System.exit(0);
        }
    }
}
