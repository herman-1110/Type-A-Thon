package finalproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class otherProfileInterface {
    JLabel sProfile, allTimeWPM, allTimeAccuracy, last10WPM, last10Accuracy, search, allTime, last10, suddenDeath;
    
    otherProfileInterface (String username){
        search = new JLabel();
        search.setBounds(320, -60, 450, 150);
        search.setText("Search:");
        search.setForeground(new Color(226, 183, 20));
        search.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        search.setLayout(null);
        
        allTime = new JLabel();
        allTime.setBounds(40, 200, 450, 150);
        allTime.setText("All Time:");
        allTime.setForeground(new Color(226, 183, 20));
        allTime.setFont(new Font("Banana Grotesk", Font.BOLD, 37));
        allTime.setLayout(null);
        
        last10 = new JLabel();
        last10.setBounds(350, 200, 450, 150);
        last10.setText("Last 10 Games:");
        last10.setForeground(new Color(226, 183, 20));
        last10.setFont(new Font("Banana Grotesk", Font.BOLD, 37));
        last10.setLayout(null);
        
        suddenDeath = new JLabel();
        suddenDeath.setBounds(720, 200, 450, 150);
        suddenDeath.setText("Sudden Death:");
        suddenDeath.setForeground(new Color(226, 183, 20));
        suddenDeath.setFont(new Font("Banana Grotesk", Font.BOLD, 37));
        suddenDeath.setLayout(null);
        
        try {
            sProfile = new JLabel();
            sProfile.setBounds(185, 30, 1000, 150);
            sProfile.setText(username + "'s Profile");
            sProfile.setForeground(new Color(226, 183, 20));
            sProfile.setFont(new Font("Banana Grotesk", Font.BOLD, 45));
            sProfile.setLayout(null);
            
            allTimeWPM = new JLabel();
            allTimeWPM.setBounds(60, 315, 400, 50);
            allTimeWPM.setText(String.format("WPM: %.2f", Double.parseDouble(database.calculateAverage("allTime", "WPM", username))));
            allTimeWPM.setForeground(new Color(97, 99, 102));
            allTimeWPM.setFont(new Font("Banana Grotesk", Font.BOLD, 25));
            allTimeWPM.setLayout(null);

            allTimeAccuracy = new JLabel();
            allTimeAccuracy.setBounds(60, 355, 400, 50);
            allTimeAccuracy.setText(String.format("Accuracy: %.2f %%", Double.parseDouble(database.calculateAverage("allTime", "Accuracy", username))));
            allTimeAccuracy.setForeground(new Color(97, 99, 102));
            allTimeAccuracy.setFont(new Font("Banana Grotesk", Font.BOLD, 25));
            allTimeAccuracy.setLayout(null);

            last10WPM = new JLabel();
            last10WPM.setBounds(370, 315, 400, 50);
            last10WPM.setText(String.format("WPM: %.2f", Double.parseDouble(database.calculateAverage("last10", "WPM", username))));
            last10WPM.setForeground(new Color(97, 99, 102));
            last10WPM.setFont(new Font("Banana Grotesk", Font.BOLD, 25));
            last10WPM.setLayout(null);

            last10Accuracy = new JLabel();
            last10Accuracy.setBounds(370, 355, 400, 50);
            last10Accuracy.setText(String.format("Accuracy: %.2f %%", Double.parseDouble(database.calculateAverage("last10", "Accuracy", username))));
            last10Accuracy.setForeground(new Color(97, 99, 102));
            last10Accuracy.setFont(new Font("Banana Grotesk", Font.BOLD, 25));
            last10Accuracy.setLayout(null);
            
        } catch (Exception e){
        }
    }
}
