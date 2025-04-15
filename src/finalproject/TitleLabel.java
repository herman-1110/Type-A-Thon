package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class TitleLabel extends JLabel{
    TitleLabel(){
        ImageIcon image = new ImageIcon(new ImageIcon("typeathon1.jpg").getImage().getScaledInstance(120,115, Image.SCALE_SMOOTH));
        Border border = BorderFactory.createLineBorder(Color.GRAY,5);
        
        this.setText("Type-A-Thon");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setForeground(new Color(226, 183, 20));
        this.setFont(new Font("Banana Grotesk",Font.BOLD,20));
        this.setIconTextGap(15);
        this.setBorder(border);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(10, 5, 150, 180);
    }
}
