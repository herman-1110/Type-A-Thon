package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class signInMessage extends JLabel{
    signInMessage(int a){
        switch(a){
            case 0:{
                this.setText(null);
                break;
            }
            case 1:{
                this.setText("Username not found.");
                break;
            }
            case 2:{
                this.setText("Incorrect password.");
                break;
            }
            case 3:{
                this.setText("Problem with logging in. Try again later.");
            }
        }
        this.setBounds(30, 405, 250, 15);
        this.setForeground(Color.RED);
        this.setFont(new Font("Banana Grotesk", Font.BOLD, 12));
        this.setLayout(null);
    }
}
