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

public class signInFrame extends JFrame implements ActionListener{
    private static signInFrame instance;
    JButton signIn, signUp, guest, exit;
    static JPasswordField password;
    static JTextField username;
    signInMessage getMessage = new signInMessage(0);
    
    
    signInFrame(){
        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        
        this.setLayout(null);  
        this.setTitle("Type-A-Thon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(880, 495);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(53,54,58));
        this.setLocationRelativeTo(null);

        username = new JTextField();
        username.setBounds(30, 270, 250, 35);
        username.setPreferredSize(new Dimension(250, 35));
        username.setFont(new Font("Banana Grotesk", Font.PLAIN, 18));
        username.setForeground(new Color(226, 183, 20));
        username.setBackground(new Color(44, 46, 49));
        username.setCaretColor(new Color(226, 183, 20));
        username.setBorder(BorderFactory.createEmptyBorder());
        
        password = new JPasswordField();
        password.setBounds(30, 365, 250, 35);
        password.setPreferredSize(new Dimension(250, 35));
        password.setFont(new Font("Banana Grotesk", Font.PLAIN, 18));
        password.setEchoChar('*');
        password.setForeground(new Color(226, 183, 20));
        password.setBackground(new Color(44, 46, 49));
        password.setCaretColor(new Color(226, 183, 20));
        password.setBorder(BorderFactory.createEmptyBorder());
        
        signIn = new JButton();
        signIn.setBounds(290, 270, 75, 35);
        signIn.addActionListener(this);
        signIn.setText("Sign In");
        signIn.setFocusable(false);
        signIn.setFont(new Font("Banana Grotesk", Font.BOLD, 16));
        signIn.setBackground(new Color(209, 208, 197));
        signIn.setBorder(BorderFactory.createEmptyBorder());
        
        signUp = new JButton();
        signUp.setBounds(505, 230, 75, 35);
        signUp.addActionListener(this);
        signUp.setText("Sign Up");
        signUp.setFocusable(false);
        signUp.setFont(new Font("Banana Grotesk", Font.BOLD, 16));
        signUp.setBackground(new Color(209, 208, 197));
        signUp.setBorder(BorderFactory.createEmptyBorder());
        
        guest = new JButton();
        guest.setBounds(505, 295, 105, 35);
        guest.addActionListener(this);
        guest.setText("<html><div style='text-align: center;'>Continue As<br>Guest</div></html>");
        guest.setFocusable(false);
        guest.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        guest.setBackground(new Color(209, 208, 197));
        guest.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(795, 420, 60, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        TitleLabel title = new TitleLabel();
        this.add(title);
        signInInterface signInInterface = new signInInterface();
        this.add(signInInterface.typeAThon);
        this.add(signInInterface.username);
        this.add(signInInterface.password);
        this.add(signInInterface.noAcc);
        this.add(signInInterface.or);
        this.add(username);
        this.add(password);
        this.add(signIn);
        this.add(signUp);
        this.add(guest);
        this.add(exit);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == signIn){
            boolean read = false;
            Component[] message = this.getContentPane().getComponents();
            for (Component messages : message){
                if (messages instanceof signInMessage){
                    this.getContentPane().remove(messages);
                }
            }
            
            try {
                if (database.readDatabase(username.getText(), password.getText())){
                    this.remove(getMessage);
                    read = true;
                    this.setVisible(false);
                    new myProfileFrame();
                }
                else if (!database.readDatabase(username.getText(), null)){
                    getMessage = new signInMessage(1);
                }
                else if (!database.readDatabase(username.getText(), password.getText())){
                    getMessage = new signInMessage(2);
                }
            } catch (Exception f){
                getMessage = new signInMessage(3);
            }
            
            if (!read){
                this.add(getMessage);
            }
            revalidate();
            repaint();
        }
        
        if(e.getSource() == signUp){
            this.setVisible(false);
            new signUpFrame();
        }
        
        if(e.getSource() == exit){
            System.exit(0);
        }
        
        if(e.getSource() == guest){
            this.setVisible(false);
            new gameGuestFrame();
        }
    }
    
    public static signInFrame getInstance() {
        if (instance == null){
            instance = new signInFrame();
        }
        return instance;
    }
}