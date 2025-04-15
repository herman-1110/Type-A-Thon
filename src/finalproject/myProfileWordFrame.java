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

public class myProfileWordFrame extends JFrame implements ActionListener{
    JButton exit, back;
    JLabel mispelled, info;
    JPanel background;
    myProfileWordInterface myProfileWordInterface = new myProfileWordInterface();
    
    myProfileWordFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("Top Misspelled Words");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 690);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        mispelled = new JLabel();
        mispelled.setBounds(160, 50, 600, 80);
        mispelled.setText("<html><div style='text-align: center;'>My Top<br>Mispelled Words</div></html>");
        mispelled.setForeground(new Color(226, 183, 20));
        mispelled.setFont(new Font("Banana Grotesk", Font.BOLD, 33));
        mispelled.setLayout(null);
        
        info = new JLabel();
        info.setBounds(30, 155, 390, 80);
        info.setText("#                     Word                                                          Occ");
        info.setForeground(new Color(97, 99, 102));
        info.setBackground(new Color(53, 54, 58));
        info.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        info.setLayout(null);
        
        background = new JPanel();
        background.setBackground(new Color(44, 46, 49));
        background.setBounds(15, 215, 405, 420);
        background.setLayout(null);
        
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
        this.add(title);
        this.add(myProfileWordInterface.listScroll);
        this.add(background);
        this.add(mispelled);
        this.add(info);
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
