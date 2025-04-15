package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class otherProfileMessage extends JLabel{
    otherProfileMessage(){
        this.setBounds(390, -35, 450, 150);
        this.setText("No user found");
        this.setForeground(Color.RED);
        this.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        this.setLayout(null);
    }
}
