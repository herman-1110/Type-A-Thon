package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
        
public class leaderboardInterface {
    DefaultTableModel list;
    JLabel leaderboard, rank, info;
    JScrollPane listScroll;
    JTable listTable;
    JPanel background;
    
    leaderboardInterface(){
        
        info = new JLabel();
        info.setBounds(30, 155, 390, 80);
        info.setText("#                     Name                                                             WPM");
        info.setForeground(new Color(97, 99, 102));
        info.setBackground(new Color(53, 54, 58));
        info.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        info.setLayout(null);
        
        leaderboard = new JLabel();
        leaderboard.setBounds(165, 70, 250, 35);
        leaderboard.setText("Leaderboards");
        leaderboard.setForeground(new Color(226, 183, 20));
        leaderboard.setFont(new Font("Banana Grotesk", Font.BOLD, 37));
        leaderboard.setLayout(null);
        
        list = new DefaultTableModel();
        list.addColumn("rank");
        list.addColumn("name");
        list.addColumn("WPM");
        
        listTable = new JTable(list);
        listTable.setBackground(new Color(44, 46, 49));
        listTable.setShowGrid(false);
        listTable.getTableHeader().setUI(null);
        listTable.setFont(new Font("Banana Grotesk", Font.BOLD, 17));
        listTable.setForeground(new Color(226, 183, 20));
        listTable.setRowHeight(50); 
        listTable.setEnabled(false);
        
        setPreferredColumnWidth(listTable, 0, 85);
        setPreferredColumnWidth(listTable, 1, 265);
        setPreferredColumnWidth(listTable, 2, 100);
        
        listScroll = new JScrollPane(listTable);
        listScroll.setBounds(25, 215, 395, 420);
        listScroll.setBorder(BorderFactory.createEmptyBorder());
        listScroll.setBackground(new Color(44, 46, 49));
        listScroll.getViewport().setBackground(new Color(44, 46, 49));
        listScroll.getVerticalScrollBar().setBackground(new Color(44, 46, 49));
        listScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(97, 99, 102);
            }
            
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
        
        background = new JPanel();
        background.setBackground(new Color(44, 46, 49));
        background.setBounds(15, 215, 405, 420);
        background.setLayout(null);
        
        try {
            Map<String, String> ranking = database.sort("leaderboard", null);
            int i = 1;
            for (Map.Entry<String, String> entry : ranking.entrySet()){
                list.addRow(new Object[]{i, entry.getKey(), String.format("%.2f", Float.parseFloat(entry.getValue()))});
                i++;
            }
        } catch(Exception e){
        }
    }
    
    private void setPreferredColumnWidth(JTable table, int columnIndex, int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setPreferredWidth(width);
    }
}