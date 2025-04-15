package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class signUpMessage extends JLabel{
    signUpMessage(int a){
        switch (a){
            case 0:{
                this.setText("Profile created successfully!");
                break;
            }
            case 1:{
                this.setText("Please enter a username.");
                break;
            }
            case 2:{
                this.setText("Please enter a password.");
                break;
            }
            case 3:{
                this.setText("The username is unavailable.");
                break;
            }
            case 4:{
                this.setText("The passwords are not matching.");
                break;
            }
            case 5:{
                this.setText("<html>Problem with creating account.<br>Try again later.</html>");
                break;
            }
            case 6:{
                this.setText("<html>Username can only have<br>15 characters.</html>");
                break;
            }
        }
        this.setBounds(525, 310, 250, 35);
        this.setForeground(Color.RED);
        this.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        this.setLayout(null);
    }
}
