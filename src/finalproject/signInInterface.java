package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class signInInterface {
    JLabel typeAThon, username, password, noAcc, or;
    
    signInInterface(){
        typeAThon = new JLabel();
        typeAThon.setBounds(260, 15, 450, 150);
        typeAThon.setText("Type-A-Thon");
        typeAThon.setForeground(new Color(226, 183, 20));
        typeAThon.setFont(new Font("Banana Grotesk", Font.BOLD, 65));
        typeAThon.setLayout(null);
        
        username = new JLabel();
        username.setBounds(30, 240, 150, 30);
        username.setText("Username:");
        username.setForeground(new Color(226, 183, 20));
        username.setFont(new Font("Banana Grotesk", Font.BOLD, 18));
        username.setLayout(null);
        
        password = new JLabel();
        password.setBounds(30, 335, 150, 30);
        password.setText("Password:");
        password.setForeground(new Color(226, 183, 20));
        password.setFont(new Font("Banana Grotesk", Font.BOLD, 18));
        password.setLayout(null);
        
        noAcc = new JLabel();
        noAcc.setBounds(500, 200, 150, 30);
        noAcc.setText("No account yet ?");
        noAcc.setForeground(new Color(226, 183, 20));
        noAcc.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        noAcc.setLayout(null);
        
        or = new JLabel();
        or.setBounds(520, 265, 150, 30);
        or.setText("OR");
        or.setForeground(new Color(226, 183, 20));
        or.setFont(new Font("Banana Grotesk", Font.BOLD, 11));
        or.setLayout(null);
    }
}
