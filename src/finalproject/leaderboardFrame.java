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

public class leaderboardFrame extends JFrame implements ActionListener{
    JButton exit, back;
    leaderboardInterface leaderboardInterface;
    
    leaderboardFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("Leaderboards");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 690);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        back = new JButton();
        back.setBounds(370, 5, 60, 25);
        back.addActionListener(this);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        back.setBackground(new Color(209, 208, 197));
        back.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(145, 5, 60, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        TitleLabel title = new TitleLabel();
        title.setBounds(10, 5, 135, 155);
        title.setIconTextGap(5);
        leaderboardInterface = new leaderboardInterface();
        this.add(leaderboardInterface.listScroll);
        this.add(leaderboardInterface.leaderboard);
        this.add(leaderboardInterface.info);
        this.add(leaderboardInterface.background);
        this.add(title);
        this.add(back);
        this.add(exit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new myProfileFrame();
            this.dispose();
        }
        
        if (e.getSource() == exit){
            System.exit(0);
        }
    }
}
