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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signUpFrame extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField  password, rePassword;
    JButton createProfile, back;
    signUpMessage getMessage;
    
    signUpFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);
        this.setTitle("Sign Up");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 450);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53, 54, 58));
        this.setLocationRelativeTo(null);
        
        username = new JTextField();
        username.setBounds(185, 225, 250, 25);
        username.setPreferredSize(new Dimension(250, 25));
        username.setFont(new Font("Banana Grotesk", Font.PLAIN, 15));
        username.setForeground(new Color(226, 183, 20));
        username.setBackground(new Color(44, 46, 49));
        username.setCaretColor(new Color(226, 183, 20));
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        password = new JPasswordField();
        password.setBounds(185, 280, 250, 25);
        password.setPreferredSize(new Dimension(250, 25));
        password.setFont(new Font("Banana Grotesk", Font.PLAIN, 15));
        password.setEchoChar('*');
        password.setForeground(new Color(226, 183, 20));
        password.setBackground(new Color(44, 46, 49));
        password.setCaretColor(new Color(226, 183, 20));
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        rePassword = new JPasswordField();
        rePassword.setBounds(185, 335, 250, 25);
        rePassword.setPreferredSize(new Dimension(250, 25));
        rePassword.setFont(new Font("Banana Grotesk", Font.PLAIN, 15));
        rePassword.setEchoChar('*');
        rePassword.setForeground(new Color(226, 183, 20));
        rePassword.setBackground(new Color(44, 46, 49));
        rePassword.setCaretColor(new Color(226, 183, 20));
        rePassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        createProfile = new JButton();
        createProfile.setBounds(525, 245, 150, 60);
        createProfile.addActionListener(this);
        createProfile.setText("<html><div style='text-align: center;'>Create a new<br>profile</div></html>");
        createProfile.setFocusable(false);
        createProfile.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        createProfile.setBackground(new Color(209, 208, 197));
        createProfile.setBorder(BorderFactory.createEmptyBorder());
        
        back = new JButton();
        back.setBounds(695, 365, 60, 25);
        back.addActionListener(this);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        back.setBackground(new Color(209, 208, 197));
        back.setBorder(BorderFactory.createEmptyBorder());
        
        TitleLabel title = new TitleLabel();
        signUpInterface signUpInterface = new signUpInterface();
        this.add(title);
        this.add(username);
        this.add(password);
        this.add(rePassword);
        this.add(createProfile);
        this.add(back);
        this.add(signUpInterface.welcome);
        this.add(signUpInterface.username);
        this.add(signUpInterface.password);
        this.add(signUpInterface.rePassword);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createProfile){
            try {
                if (username.getText().trim().isBlank()){
                    getMessage = new signUpMessage(1);
                }
                else if (database.readDatabase(username.getText().trim(), null)){
                    getMessage = new signUpMessage(3);
                }
                else if (username.getText().trim().length() > 15){
                    getMessage = new signUpMessage(6);
                }
                else if (password.getText().isBlank() || rePassword.getText().isBlank()){
                    getMessage = new signUpMessage(2);
                }
                else if (!password.getText().equals(rePassword.getText())){
                    getMessage = new signUpMessage(4);
                }
                else {
                    database.insertData("userlist", username.getText().trim(), password.getText(), null);
                    getMessage = new signUpMessage(0);
                    username.setText("");
                    password.setText("");
                    rePassword.setText("");
                }
            } catch (Exception f){
                getMessage = new signUpMessage(5);
            }
            
            Component[] message = this.getContentPane().getComponents();
            for (Component messages : message){
                if (messages instanceof signUpMessage){
                    this.getContentPane().remove(messages);
                }
            }
            this.add(getMessage);
            revalidate();
            repaint();
        }
        
        if (e.getSource() == back) { 
            signInFrame instance = signInFrame.getInstance();
            instance.setVisible(true);
            this.dispose();
        }
    }  
}