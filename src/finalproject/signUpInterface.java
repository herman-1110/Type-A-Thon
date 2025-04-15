package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class signUpInterface {
    JLabel welcome, username, password, rePassword;
    
    signUpInterface(){
        welcome = new JLabel();
        welcome.setBounds(300, 15, 450, 150);
        welcome.setText("<html><div style='text-align: center;'>Welcome to<br>Type-A-Thon !</div></html>");
        welcome.setForeground(new Color(226, 183, 20));
        welcome.setFont(new Font("Banana Grotesk", Font.BOLD, 50));
        welcome.setLayout(null);
        
        username = new JLabel();
        username.setBounds(25, 220, 200, 35);
        username.setText("Username:");
        username.setForeground(new Color(226, 183, 20));
        username.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        username.setLayout(null);
        
        password = new JLabel();
        password.setBounds(25, 275, 200, 35);
        password.setText("Password:");
        password.setForeground(new Color(226, 183, 20));
        password.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        password.setLayout(null);
        
        rePassword = new JLabel();
        rePassword.setBounds(25, 330, 200, 35);
        rePassword.setText("Re-enter password:");
        rePassword.setForeground(new Color(226, 183, 20));
        rePassword.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        rePassword.setLayout(null);
    }
}
