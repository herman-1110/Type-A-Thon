package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class myProfileSuddenDeathInterface {
    DefaultTableModel list;
    JTable listTable;
    JScrollPane listScroll;
    
    myProfileSuddenDeathInterface(){
        list = new DefaultTableModel();
        list.addColumn("rank");
        list.addColumn("WPM");
        
        listTable = new JTable(list);
        listTable.setBackground(new Color(44, 46, 49));
        listTable.setShowGrid(false);
        listTable.getTableHeader().setUI(null);
        listTable.setFont(new Font("Banana Grotesk", Font.BOLD, 17));
        listTable.setForeground(new Color(226, 183, 20));
        listTable.setRowHeight(50); 
        listTable.setEnabled(false);
        
        setPreferredColumnWidth(listTable, 0, 130);
        setPreferredColumnWidth(listTable, 1, 95);
        
        listScroll = new JScrollPane(listTable);
        listScroll.setBounds(35, 215, 285, 420);
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
        
        try {
            Map<String, String> ranking = database.sort("suddenDeath", signInFrame.username.getText().trim());
            int i = 1;
            for (Map.Entry<String, String> entry : ranking.entrySet()){
                entry.getKey();
                list.addRow(new Object[]{i, String.format("%.2f", Float.parseFloat(entry.getValue()))});
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
