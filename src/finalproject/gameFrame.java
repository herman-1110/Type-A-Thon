package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class gameFrame extends JFrame implements ActionListener, KeyListener{
    
    private int characters, secForButton1, secForButton2, secForButton3, secForButton4, length, elapsedTime
            , correctCharacter, secondLine, thirdLine, fourthLine, fifthLine, totalSecond, previousSecond
            , tempSecond, lastSpaceCharacter, timer, spaceCharacter;
    private double wpm, count, accuracy;
    private boolean running, end, option1, option2, option3, option4, drawStringEnabled, previousTime, previousWordOrQuote;
    
    private String passageLine1 = "";
    private String passageLine2 = "";
    private String passageLine3 = "";
    private String passageLine4 = "";
    private String passageLine5 = "";
    private String passage = ""; 
    private String typePass = "";
    private String spaceWords = "";
    private String wrongWords = "";
    private String[] mispelled;
    private String secondString;
    
    private char [] pass;
    
    private ArrayList <String> pas = new ArrayList<>();
    private ArrayList <String> pas2 = new ArrayList<>();
    private ArrayList <String> pas3 = new ArrayList<>();
    private ArrayList <String> pas4 = new ArrayList<>();
    private ArrayList <String> pas5 = new ArrayList<>();
    private ArrayList <Character> correctWordBackspace = new ArrayList<>();
    private ArrayList <Character> wrongWordBackspace = new ArrayList<>();
    private ArrayList <Character> extraWordBackspace = new ArrayList<>();
    
    Words word = new Words();
    
    Timer time;
    
    JButton timer1, timer2, timer3, timer4, timedMode, wordMode, quoteMode, word1, word2, word3, word4, restartButton, nextButton, exit, back;
    JLabel  timerLabel, mainLabel, seperateLabel, seperateLabel1, seperateLabel2, seperateLabel3, wpmLabel, accLabel, wpmScore, accScore, sourceLabel, source, mispelledLabel, wordLabel, timeLabel;
    JCheckBox checkbox, suddenDeath, correctionFacility;
    ImageIcon image;
    DefaultTableModel list;
    JTable listTable;
    
    public gameFrame(){
        
        accuracy = 0;
        spaceCharacter = 0;
        correctCharacter = 0;
        length = 0;
        wpm = 0;
        count = 0;
        characters = 0;
        secondString = "";
        wrongWords = "";
        option1 = false;
        option2 = false;
        option3 = false;
        option4 = false;
        drawStringEnabled = true;
        
        mispelledLabel = new JLabel("Top 10 mispelled words:");
        mispelledLabel.setForeground(new Color(0x7c7f7f));
        mispelledLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 16));
        mispelledLabel.setBackground(new Color(0x333333));
        mispelledLabel.setOpaque(true);
        mispelledLabel.setBounds(760, 187, 190, 50);
        mispelledLabel.setFocusable(false);
        mispelledLabel.setVisible(false);
        
        list = new DefaultTableModel();
        list.addColumn("word");
        
        listTable = new JTable(list);
        listTable.setBackground(new Color(0x333333));
        listTable.setShowGrid(false);
        listTable.getTableHeader().setUI(null);
        listTable.setFont(new Font("Banana Grotesk", Font.BOLD, 17));
        listTable.setForeground(new Color(226, 183, 20));
        listTable.setRowHeight(35); 
        listTable.setEnabled(false);
        listTable.setBounds(990, 195, 1000, 350);
        
        timerLabel = new JLabel();
        timerLabel.setForeground(new Color(0xE9D66B));
        timerLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 17));
        timerLabel.setBackground(new Color(0x333333));
        timerLabel.setOpaque(true);
        timerLabel.setBounds(575, 210, 30, 60);
        timerLabel.setFocusable(false);
        timerLabel.setVisible(false);
        
        sourceLabel = new JLabel("Source");
        sourceLabel.setForeground(new Color(0x7c7f7f));
        sourceLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 24));
        sourceLabel.setBackground(new Color(0x333333));
        sourceLabel.setOpaque(true);
        sourceLabel.setBounds(394, 401, 84, 30);
        sourceLabel.setFocusable(false);
        
        source = new JLabel();
        source.setForeground(new Color(0xE9D66B));
        source.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        source.setBackground(new Color(0x333333));
        source.setOpaque(true);
        source.setBounds(492, 397, 600, 40);
        source.setFocusable(false);
        
        seperateLabel = new JLabel("|");
        seperateLabel.setForeground(new Color(0xE9D66B));
        seperateLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        seperateLabel.setBackground(new Color(0x333333));
        seperateLabel.setOpaque(true);
        seperateLabel.setBounds(397, 115, 12, 12);
        seperateLabel.setFocusable(false);
        
        seperateLabel1 = new JLabel("|");
        seperateLabel1.setForeground(new Color(0xE9D66B));
        seperateLabel1.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        seperateLabel1.setBackground(new Color(0x333333));
        seperateLabel1.setOpaque(true);
        seperateLabel1.setBounds(641, 115, 12, 12);
        seperateLabel1.setFocusable(false);
        
        seperateLabel2 = new JLabel("|");
        seperateLabel2.setForeground(new Color(0xE9D66B));
        seperateLabel2.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        seperateLabel2.setBackground(new Color(0x333333));
        seperateLabel2.setOpaque(true);
        seperateLabel2.setBounds(888, 115, 12, 12);
        seperateLabel2.setFocusable(false);
        
        seperateLabel3 = new JLabel("|");
        seperateLabel3.setForeground(new Color(0xE9D66B));
        seperateLabel3.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        seperateLabel3.setBackground(new Color(0x333333));
        seperateLabel3.setOpaque(true);
        seperateLabel3.setBounds(1018, 115, 12, 12);
        seperateLabel3.setFocusable(false);
        
        wpmLabel = new JLabel("WPM");
        wpmLabel.setForeground(new Color(0x7c7f7f));
        wpmLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 24));
        wpmLabel.setBackground(new Color(0x333333));
        wpmLabel.setOpaque(true);
        wpmLabel.setBounds(393, 298, 80, 30);
        wpmLabel.setFocusable(false);
        
        accLabel = new JLabel("Acc");
        accLabel.setForeground(new Color(0x7c7f7f));
        accLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 24));
        accLabel.setBackground(new Color(0x333333));
        accLabel.setOpaque(true);
        accLabel.setBounds(393, 349, 80, 30);
        accLabel.setFocusable(false);
        
        wpmScore = new JLabel();
        wpmScore.setForeground(new Color(0xE9D66B));
        wpmScore.setFont(new Font("Banana Grotesk", Font.BOLD, 16));
        wpmScore.setBackground(new Color(0x333333));
        wpmScore.setOpaque(true);
        wpmScore.setBounds(494, 300, 110, 30);
        wpmScore.setFocusable(false);
        
        accScore = new JLabel();
        accScore.setForeground(new Color(0xE9D66B));
        accScore.setFont(new Font("Banana Grotesk", Font.BOLD, 16));
        accScore.setBackground(new Color(0x333333));
        accScore.setOpaque(true);
        accScore.setBounds(494, 350, 110, 30);
        accScore.setFocusable(false);
        
        suddenDeath = new JCheckBox(" 💀"); 
        suddenDeath.setBounds(908, 106, 50, 30);
        suddenDeath.setForeground(new Color(0xBBBBBB));
        suddenDeath.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        suddenDeath.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        suddenDeath.setBackground(new Color(0x333333));
        suddenDeath.setFocusable(false);
        
        correctionFacility = new JCheckBox(" 🛠"); 
        correctionFacility.setBounds(968, 106, 50, 30);
        correctionFacility.setForeground(new Color(0xBBBBBB));
        correctionFacility.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        correctionFacility.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        correctionFacility.setBackground(new Color(0x333333));
        correctionFacility.setFocusable(false);
        
        timer1 = new JButton("15"); 
        timer1.setBounds(405, 106, 50, 30);
        timer1.setForeground(new Color(0xBBBBBB));
        timer1.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        timer1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        timer1.setBackground(new Color(0x333333));
        timer1.setFocusable(false);
        
        timer2 = new JButton("30");
        timer2.setBounds(465, 106, 50, 30);
        timer2.setForeground(new Color(0xBBBBBB));
        timer2.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        timer2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        timer2.setBackground(new Color(0x333333));
        timer2.setFocusable(false);
        
        timer3 = new JButton("45");
        timer3.setBounds(525, 106, 56, 30);
        timer3.setForeground(new Color(0xBBBBBB));
        timer3.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        timer3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        timer3.setBackground(new Color(0x333333));
        timer3.setFocusable(false);
        
        timer4 = new JButton("60");
        timer4.setBounds(588, 106, 50, 30);
        timer4.setForeground(new Color(0xBBBBBB));
        timer4.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        timer4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        timer4.setBackground(new Color(0x333333));
        timer4.setFocusable(false);
        
        timedMode = new JButton("timed");
        timedMode.setForeground(new Color(0xBBBBBB));
        timedMode.setBounds(180, 106, 60, 30);
        timedMode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        timedMode.setFont(new Font("Banana Grotesk",Font.BOLD, 13));
        timedMode.setBackground(new Color(0x333333));
        timedMode.setFocusable(false);
        
        wordMode = new JButton("words");
        wordMode.setForeground(new Color(0xBBBBBB));
        wordMode.setBounds(250, 106, 60, 30);
        wordMode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        wordMode.setFont(new Font("Banana Grotesk",Font.BOLD, 13));
        wordMode.setBackground(new Color(0x333333));
        wordMode.setFocusable(false);
       
        quoteMode = new JButton("quotes");
        quoteMode.setForeground(new Color(0xBBBBBB));
        quoteMode.setBounds(323, 106, 66, 30);
        quoteMode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        quoteMode.setFont(new Font("Banana Grotesk",Font.BOLD, 13));
        quoteMode.setBackground(new Color(0x333333));
        quoteMode.setFocusable(false);
        
        word1 = new JButton("10"); 
        word1.setBounds(649, 106, 50, 30);
        word1.setForeground(new Color(0xBBBBBB));
        word1.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        word1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        word1.setBackground(new Color(0x333333));
        word1.setFocusable(false);
        
        word2 = new JButton("25");
        word2.setBounds(709, 106, 50, 30);
        word2.setForeground(new Color(0xBBBBBB));
        word2.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        word2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        word2.setBackground(new Color(0x333333));
        word2.setFocusable(false);
       
        word3 = new JButton("50");
        word3.setBounds(769, 106, 56, 30);
        word3.setForeground(new Color(0xBBBBBB));
        word3.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        word3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        word3.setBackground(new Color(0x333333));
        word3.setFocusable(false);
        
        word4 = new JButton("100");
        word4.setBounds(834, 106, 50, 30);
        word4.setForeground(new Color(0xBBBBBB));
        word4.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        word4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        word4.setBackground(new Color(0x333333));
        word4.setFocusable(false);
        
        restartButton = new JButton("↺ restart");
        restartButton.setBounds(430, 470, 80, 30);
        restartButton.setForeground(new Color(0xBBBBBB));
        restartButton.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        restartButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        restartButton.setBackground(new Color(0x333333));
        restartButton.setFocusable(false);
        
        nextButton = new JButton("▷ next test");
        nextButton.setBounds(630, 470, 80, 30);
        nextButton.setForeground(new Color(0xBBBBBB));
        nextButton.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        nextButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nextButton.setBackground(new Color(0x333333));
        nextButton.setFocusable(false);
        
        back = new JButton();
        back.setBounds(1250, 5, 60, 25);
        back.addActionListener(this);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("Banana Grotesk", Font.BOLD, 15));
        back.setBackground(new Color(209, 208, 197));
        back.setBorder(BorderFactory.createEmptyBorder());
        
        exit = new JButton();
        exit.setBounds(165, 5, 60, 20);
        exit.addActionListener(this);
        exit.setText("Exit >");
        exit.setFocusable(false);
        exit.setFont(new Font("Banana Grotesk", Font.BOLD, 14));
        exit.setForeground(new Color(226, 183, 20));
        exit.setBackground(new Color(53,54,58));
        exit.setBorder(BorderFactory.createEmptyBorder());
        
        timeLabel = new JLabel();
        timeLabel.setText("timed");
        timeLabel.setForeground(new Color(0xE9D66B));
        timeLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 10));
        timeLabel.setBackground(new Color(0x333333));
        timeLabel.setOpaque(true);
        timeLabel.setBounds(510, 80, 110, 30);
        timeLabel.setFocusable(false);
        
        wordLabel = new JLabel();
        wordLabel.setText("words");
        wordLabel.setForeground(new Color(0xE9D66B));
        wordLabel.setFont(new Font("Banana Grotesk", Font.BOLD, 10));
        wordLabel.setBackground(new Color(0x333333));
        wordLabel.setOpaque(true);
        wordLabel.setBounds(749, 80, 110, 30);
        wordLabel.setFocusable(false);
        
        checkbox = new JCheckBox();
        checkbox.setText(" punctuation");
        checkbox.setForeground(new Color(0xBBBBBB));
        checkbox.setFocusable(false);
        checkbox.setBounds(1034, 106, 150, 30);
        checkbox.setFont(new Font("Banana Grotesk", Font.BOLD, 13));
        checkbox.setBackground(new Color(0x333333));
        checkbox.setVisible(true);
        
        timer1.setEnabled(false);
        timer2.setEnabled(false);
        timer3.setEnabled(false);
        timer4.setEnabled(false);
        word1.setEnabled(false);
        word2.setEnabled(false);
        word3.setEnabled(false);
        word4.setEnabled(false);
        
        if (word.sizeCorrectioin() > 0) 
            correctionFacility.setEnabled(true);
        else
            correctionFacility.setEnabled(false);
        
        timedMode.addActionListener(this);
        wordMode.addActionListener(this);
        quoteMode.addActionListener(this);
        correctionFacility.addActionListener(this);
        
        suddenDeath.setVisible(true);
        correctionFacility.setVisible(true);
        
        TitleLabel title = new TitleLabel();
        this.add(title);
        this.setLayout(null);
        this.setSize(1332, 693);
        this.setTitle("Type-A-Thon");
        this.add(timerLabel);
        this.add(seperateLabel);
        this.add(seperateLabel1);
        this.add(seperateLabel2);
        this.add(seperateLabel3);
        this.add(timer1); 
        this.add(timer2);
        this.add(timer3);
        this.add(timer4);
        this.add(timedMode);
        this.add(wordMode);
        this.add(quoteMode);
        this.add(word1);
        this.add(word2);
        this.add(word3);
        this.add(word4);
        this.add(suddenDeath);
        this.add(correctionFacility);
        this.add(back);
        this.add(exit);
        this.add(wordLabel);
        this.add(timeLabel);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addKeyListener(this);
        this.getContentPane().setBackground(new Color(0x333333));

        ImageIcon image = new ImageIcon(new ImageIcon("paimon.jpg").getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        this.setIconImage(image.getImage());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == exit){
            try {
                Words.correctionFacility.subList(0, database.getMisspelledWords(signInFrame.username.getText().trim()).size()).clear();
                for (String words : Words.correctionFacility){
                    database.insertData("misspelled", signInFrame.username.getText().trim(), words, null);
                }
            } catch (Exception f){
            }
            Words.correctionFacility.clear();
            this.dispose();
            System.exit(0);
        }
        
        if(e.getSource() == back){
            try {
                Words.correctionFacility.subList(0, database.getMisspelledWords(signInFrame.username.getText().trim()).size()).clear();
                for (String words : Words.correctionFacility){
                    database.insertData("misspelled", signInFrame.username.getText().trim(), words, null);
                }
            } catch (Exception f){
            }
            Words.correctionFacility.clear();
            new myProfileFrame();
            this.dispose();
        }
        
        if (correctionFacility.isSelected()) {
            checkbox.setEnabled(false);
            quoteMode.setEnabled(false);
        }
        
        if (!correctionFacility.isSelected()) {
            checkbox.setEnabled(true);
            quoteMode.setEnabled(true);
        }
        
        if (e.getSource() == timedMode){
            
            previousTime = true;
            previousWordOrQuote = false;
            
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            timer1.setEnabled(true);
            timer2.setEnabled(true);
            timer3.setEnabled(true);
            timer4.setEnabled(true);
            drawStringEnabled = true;
            
            timer1.addActionListener(this);
            timer2.addActionListener(this);
            timer3.addActionListener(this);
            timer4.addActionListener(this);
            
            word1.removeActionListener(this);
            word2.removeActionListener(this);
            word3.removeActionListener(this);
            word4.removeActionListener(this);

            timedMode.setForeground(new Color(0xE9D66B));
            wordMode.setForeground(new Color(0xBBBBBB));
            quoteMode.setForeground(new Color(0xBBBBBB));
            
            checkbox.setVisible(true);
            this.add(checkbox);
            
            source.setText(" -");

            revalidate();
            repaint();
        }
        if (e.getSource() == wordMode){
            
            previousTime = false;
            previousWordOrQuote = true;
            
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            word1.setEnabled(true);
            word2.setEnabled(true);
            word3.setEnabled(true);
            word4.setEnabled(true);
            drawStringEnabled = true;
            
            word1.addActionListener(this);
            word2.addActionListener(this);
            word3.addActionListener(this);
            word4.addActionListener(this);
            
            timer1.removeActionListener(this);
            timer2.removeActionListener(this);
            timer3.removeActionListener(this);
            timer4.removeActionListener(this);
            
            wordMode.setForeground(new Color(0xE9D66B));
            timedMode.setForeground(new Color(0xBBBBBB));
            quoteMode.setForeground(new Color(0xBBBBBB));
            
            checkbox.setVisible(false);
            
            source.setText(" -");
        }
        if (e.getSource() == quoteMode){
            
            previousTime = false;
            previousWordOrQuote = true;
            
            String [] passages = word.getQuote().split("\\|");
            String [] passageWord = passages[0].split(" ");
            
            source.setText(passages[1]);
            
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            drawStringEnabled = true;
            
            timer1.removeActionListener(this);
            timer2.removeActionListener(this);
            timer3.removeActionListener(this);
            timer4.removeActionListener(this);
            timedMode.removeActionListener(this);
            wordMode.removeActionListener(this);
            quoteMode.removeActionListener(this);
            word1.removeActionListener(this);
            word2.removeActionListener(this);
            word3.removeActionListener(this);
            word4.removeActionListener(this);
            
            quoteMode.setForeground(new Color(0xE9D66B));
            timedMode.setForeground(new Color(0xBBBBBB));
            wordMode.setForeground(new Color(0xBBBBBB));
            
            checkbox.setVisible(false);
            
            if (passageWord.length < 20) {
                
                option1 = true;
                
                for (String a : passageWord)
                    passageLine1 += a + " ";
                
                passageLine1 = passageLine1.trim();
                passage = passageLine1;
            }
            else if (passageWord.length < 40) {
                
                option2 = true;
            
                for (int i = 0; i < passageWord.length; i++) {
                    if (i < 20)
                        pas.add(passageWord[i] + " ");
                    else
                        pas2.add(passageWord[i] + " ");
                }
                
                String [] line1 = new String [pas.size()];
                String [] line2 = new String [pas2.size()];
                
                for (int i = 0; i < line1.length; i++)
                    line1[i] = pas.get(i);
                for (int i = 0; i < line2.length; i++)
                    line2[i] = pas2.get(i);
                
                for (String a : line1)
                    passageLine1 += a;
                for (String a : line2)
                    passageLine2 += a;
                for (String a : passageWord)
                    passage += a + " ";
                
                passageLine2 = passageLine2.trim();
                passage = passage.trim();
            
            }
            else if (passageWord.length < 60) {
                
                option3 = true;
                
                for (int i = 0; i < passageWord.length; i++) {
                    if (i < 20)
                        pas.add(passageWord[i] + " ");
                    else if (i < 40)
                        pas2.add(passageWord[i] + " ");
                    else 
                        pas3.add(passageWord[i] + " ");
                }
                
                String [] line1 = new String [pas.size()];
                String [] line2 = new String [pas2.size()];
                String [] line3 = new String [pas3.size()];
                
                for (int i = 0; i < line1.length; i++)
                    line1[i] = pas.get(i);
                for (int i = 0; i < line2.length; i++)
                    line2[i] = pas2.get(i);
                for (int i = 0; i < line3.length; i++) 
                    line3[i] = pas3.get(i);
            
                for (String a : line1)
                    passageLine1 += a;
                for (String a : line2)
                    passageLine2 += a;
                for (String a : line3)
                    passageLine3 += a;
                for (String a : passages)
                    passage += a + " ";
                
                passageLine3 = passageLine3.trim();
                passage = passage.trim();
            }
            else if (passageWord.length < 100) {
                
                option4 = true;
                
                for (int i = 0; i < passageWord.length; i++) {
                    if (i < 20)
                        pas.add(passageWord[i] + " ");
                    else if (i < 40)
                        pas2.add(passageWord[i] + " ");
                    else if (i < 60)
                        pas3.add(passageWord[i] + " ");
                    else if (i < 80)
                        pas4.add(passageWord[i] + " ");
                    else
                        pas5.add(passageWord[i] + " ");
                }
                
                String [] line1 = new String [pas.size()];
                String [] line2 = new String [pas2.size()];
                String [] line3 = new String [pas3.size()];
                String [] line4 = new String [pas4.size()];
                String [] line5 = new String [pas5.size()];
                
                for (int i = 0; i < line1.length; i++)
                    line1[i] = pas.get(i);
                for (int i = 0; i < line2.length; i++)
                    line2[i] = pas2.get(i);
                for (int i = 0; i < line3.length; i++) 
                    line3[i] = pas3.get(i);
                for (int i = 0; i < line2.length; i++)
                    line4[i] = pas4.get(i);
                for (int i = 0; i < line3.length; i++) 
                    line5[i] = pas5.get(i);
            
                for (String a : line1)
                    passageLine1 += a;
                for (String a : line2)
                    passageLine2 += a;
                for (String a : line3)
                    passageLine3 += a;
                for (String a : line4)
                    passageLine4 += a;
                for (String a : line5)
                    passageLine5 += a;
                for (String a : passages)
                    passage += a + " ";
                
                passageLine5 = passageLine5.trim();
                passage = passage.trim();
            }
            
            pass = passage.toCharArray();
            lastSpaceCharacter = passageWord[passageWord.length-1].length();
            
            length = passage.length();
            running = true;
            end = false;
            totalSecond = 0;
            previousSecond = totalSecond;
            timer = 0;
            
            secondString = String.format("%02d",totalSecond);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    timer += 1000;
                    totalSecond = (timer / 1000);
                    if (count >= length) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / (double)totalSecond) * 60;
                        accuracy = (correctCharacter/(double)length) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", totalSecond);
                    timerLabel.setText(secondString);
                }
            }); 
        }
        if (e.getSource() == timer1){
            
            option4 = true;
                
            String [] passages = new String [100];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(0);
            else
                passages = checkbox.isSelected() ? word.getPassageWithPun() : word.getPassage();
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [20];
            String [] line4 = new String [20];
            String [] line5 = new String [20];
            
            for (int i = 0, j = 0, k = 0, z = 0, m = 0; i < 100; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else if (i < 60) {
                    line3[k] = passages[i];
                    k++;
                }
                else if (i < 80) {
                    line4[z] = passages[i];
                    z++;
                }
                else {
                    line5[m] = passages[i];
                    m++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : line4)
                passageLine4 += a;
            for (String a : line5)
                passageLine5 += a;
            for (String a : passages)
                passage += a; 
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            checkbox.setEnabled(false);
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line5[line5.length-1].length();
            
            length = passage.length();
            secForButton1 = 15;
            previousSecond = secForButton1;
            elapsedTime = 15000;
            running = true;
            end = false;
            secondString = String.format("%02d",secForButton1);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true); 
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elapsedTime -= 1000;
                    secForButton1 = (elapsedTime / 1000) % 60;
                    if (elapsedTime < 1000) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / 15.0) * 60;
                        accuracy = (correctCharacter/count) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", secForButton1);
                    timerLabel.setText(secondString);
                }
            });
        }
        else if (e.getSource() == timer2){
            
            option4 = true;
            
            String [] passages = new String [100];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(0);
            else
                passages = checkbox.isSelected() ? word.getPassageWithPun() : word.getPassage();
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [20];
            String [] line4 = new String [20];
            String [] line5 = new String [20];
            
            for (int i = 0, j = 0, k = 0, z = 0, m = 0; i < 100; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else if (i < 60) {
                    line3[k] = passages[i];
                    k++;
                }
                else if (i < 80) {
                    line4[z] = passages[i];
                    z++;
                }
                else {
                    line5[m] = passages[i];
                    m++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : line4)
                passageLine4 += a;
            for (String a : line5)
                passageLine5 += a;
            for (String a : passages)
                passage += a;
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            checkbox.setEnabled(false);
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line5[line5.length-1].length();
            
            length = passage.length();
            secForButton2 = 30;
            previousSecond = secForButton2;
            elapsedTime = 30000;
            running = true;
            end = false;
            secondString = String.format("%02d",secForButton2);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
            this.add(timerLabel); 
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elapsedTime -= 1000;
                    secForButton2 = (elapsedTime / 1000) % 60;
                    if (elapsedTime < 1000) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / 30.0) * 60;
                        accuracy = (correctCharacter/count) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                            else {
                                database.insertData("result", signInFrame.username.getText().trim(), Double.toString(wpm), Double.toString(accuracy));
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", secForButton2);
                    timerLabel.setText(secondString);
                }
            });
        }
        else if (e.getSource() == timer3) {
            
            option4 = true;
            timer3.setForeground(new Color(0xE9D66B));
            
            String [] passages = new String [100];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(0);
            else
                passages = checkbox.isSelected() ? word.getPassageWithPun() : word.getPassage();
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [20];
            String [] line4 = new String [20];
            String [] line5 = new String [20];
            
            for (int i = 0, j = 0, k = 0, z = 0, m = 0; i < 100; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else if (i < 60) {
                    line3[k] = passages[i];
                    k++;
                }
                else if (i < 80) {
                    line4[z] = passages[i];
                    z++;
                }
                else {
                    line5[m] = passages[i];
                    m++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : line4)
                passageLine4 += a;
            for (String a : line5)
                passageLine5 += a;
            for (String a : passages)
                passage += a; 
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            checkbox.setEnabled(false);
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line5[line5.length-1].length();
            
            length = passage.length();
            secForButton3 = 45;
            previousSecond = secForButton3;
            elapsedTime = 45000;
            running = true;
            end = false;
            secondString = String.format("%02d",secForButton3);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elapsedTime -= 1000;
                    secForButton3 = (elapsedTime / 1000) % 60;
                    if (elapsedTime < 1000) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / 45.0) * 60;
                        accuracy = (correctCharacter/count) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", secForButton3);
                    timerLabel.setText(secondString);
                }
            });
        }
        else if (e.getSource() == timer4) {
            
            option4 = true;
            timer4.setForeground(new Color(0xE9D66B));
            
            String [] passages = new String [100];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(0);
            else
                passages = checkbox.isSelected() ? word.getPassageWithPun() : word.getPassage();
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [20];
            String [] line4 = new String [20];
            String [] line5 = new String [20];
            
            for (int i = 0, j = 0, k = 0, z = 0, m = 0; i < 100; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else if (i < 60) {
                    line3[k] = passages[i];
                    k++;
                }
                else if (i < 80) {
                    line4[z] = passages[i];
                    z++;
                }
                else {
                    line5[m] = passages[i];
                    m++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : line4)
                passageLine4 += a;
            for (String a : line5)
                passageLine5 += a;
            for (String a : passages)
                passage += a; 
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            checkbox.setEnabled(false);
            timer1.setEnabled(false);
            timer2.setEnabled(false);
            timer3.setEnabled(false);
            timer4.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line5[line5.length-1].length();
            
            length = passage.length();
            secForButton4 = 60;
            previousSecond = secForButton4;
            elapsedTime = 60000;
            running = true;
            end = false;
            secondString = String.format("%02d",secForButton4);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
            this.add(timerLabel); 
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elapsedTime -= 1000;
                    secForButton4 = (elapsedTime / 1000) % 60;
                    if (elapsedTime < 1000) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / 60.0) * 60;
                        accuracy = (correctCharacter/count) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", secForButton4);
                    timerLabel.setText(secondString);
                }
            });
        }
        if (e.getSource() == word1) {
            
            option1 = true;
            
            String [] passages = new String [10];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(10);
            else
                passages = word.getWord(10);
            
            for (String a : passages)
                passageLine1 += a;
            
            passage = passageLine1;
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = passages[passages.length-1].length();
            
            length = passage.length();
            running = true;
            end = false;
            totalSecond = 0;
            previousSecond = totalSecond;
            timer = 0;
            
            secondString = String.format("%02d",totalSecond);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
            this.add(timerLabel); 
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    timer += 1000;
                    totalSecond = (timer / 1000);
                    if (count >= length) {
                        time.stop();
                        wpm = ((correctCharacter / 5.0) / (double)totalSecond) * 60;
                        accuracy = (correctCharacter/(double)length) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", totalSecond);
                    timerLabel.setText(secondString);
                }
            });

        }
        else if (e.getSource() == word2) {
            
            option2 = true;
            
            String [] passages = new String [25];
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(25);
            else
                passages = word.getWord(25);
            
            String [] line1 = new String [20];
            String [] line2 = new String [5];
            
            for (int i = 0, j = 0; i < 25; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else {
                    line2[j] = passages[i];
                    j++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : passages)
                passage += a;
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line2[line2.length-1].length();
            
            length = passage.length();
            running = true;
            end = false;
            totalSecond = 0;
            previousSecond = totalSecond;
            timer = 0;
            
            secondString = String.format("%02d",totalSecond);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    timer += 1000;
                    totalSecond = (timer / 1000);
                    if (count >= length) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / (double)totalSecond) * 60;
                        accuracy = (correctCharacter/(double)length) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        end = true;
                        running = false;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", totalSecond);
                    timerLabel.setText(secondString);
                }
            });
        }
        else if (e.getSource() == word3) {
            
            option3 = true;
            
            String [] passages = new String [50];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(50);
            else
                passages = word.getWord(50);
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [10];
            
            for (int i = 0, j = 0, k = 0; i < 50; i++) {
                if (i < 20) 
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else {
                    line3[k] = passages[i];
                    k++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : passages)
                passage += a;
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line3[line3.length-1].length();
            
            length = passage.length();
            running = true;
            end = false;
            totalSecond = 0;
            previousSecond = totalSecond;
            timer = 0;
            
            secondString = String.format("%02d",totalSecond);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    timer += 1000;
                    totalSecond = (timer / 1000);
                    if (count >= length) {
                        time.stop();
                        
                        wpm = ((correctCharacter / 5.0) / (double)totalSecond) * 60;
                        accuracy = (correctCharacter/(double)length) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", totalSecond);
                    timerLabel.setText(secondString);
                }
            });
        }
        else if (e.getSource() == word4) {
            
            option4 = true;
            
            String [] passages = new String [100];
            
            if (correctionFacility.isSelected()) 
                passages = word.getCorrectFacility(0);
            else
                passages = word.getWord(100);
            
            String [] line1 = new String [20];
            String [] line2 = new String [20];
            String [] line3 = new String [20];
            String [] line4 = new String [20];
            String [] line5 = new String [20];
            
            for (int i = 0, j = 0, k = 0, z = 0, m = 0; i < 100; i++) {
                if (i < 20)
                    line1[i] = passages[i];
                else if (i < 40) {
                    line2[j] = passages[i];
                    j++;
                }
                else if (i < 60) {
                    line3[k] = passages[i];
                    k++;
                }
                else if (i < 80) {
                    line4[z] = passages[i];
                    z++;
                }
                else {
                    line5[m] = passages[i];
                    m++;
                }
            }
            
            for (String a : line1)
                passageLine1 += a;
            for (String a : line2)
                passageLine2 += a;
            for (String a : line3)
                passageLine3 += a;
            for (String a : line4)
                passageLine4 += a;
            for (String a : line5)
                passageLine5 += a;
            for (String a : passages)
                passage += a;
            
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            timedMode.setEnabled(false);
            wordMode.setEnabled(false);
            quoteMode.setEnabled(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            word1.setEnabled(false);
            word2.setEnabled(false);
            word3.setEnabled(false);
            word4.setEnabled(false);
            
            pass = passage.toCharArray();
            lastSpaceCharacter = line5[line5.length-1].length();
            
            length = passage.length();
            running = true;
            end = false;
            totalSecond = 0;
            previousSecond = totalSecond;
            timer = 0;
            
            secondString = String.format("%02d",totalSecond);
            timerLabel.setText(secondString);
            timerLabel.setVisible(true);
               
            time = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    timer += 1000;
                    totalSecond = (timer / 1000);
                    if (count >= length) {
                        time.stop();

                        wpm = ((correctCharacter / 5.0) / (double)totalSecond) * 60;
                        accuracy = (correctCharacter/(double)length) * 100;
                        int temp4 = (int)wpm;
                        int temp3 = (int)accuracy;
                        
                        try {
                            if (suddenDeath.isSelected()){
                                database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                            }
                        } catch (Exception f){
                        }
                        
                        end = true;
                        running = false;
                        
                        String temp = String.valueOf(temp4);
                        String temp2 = String.valueOf(temp3);

                        wpmScore.setText(temp);
                        accScore.setText(temp2+"%");
                        timerLabel.setVisible(false);
                        
                        repaint(); 
                    }
                    secondString = String.format("%02d", totalSecond);
                    timerLabel.setText(secondString);
                }
            });
        }
        if (e.getSource() == restartButton) {
            
            typePass = "";
            secondString = "";
            wrongWords = "";
            spaceWords = "";
            lastSpaceCharacter = 0;
            spaceCharacter = 0;
            accuracy = 0;
            correctCharacter = 0;
            tempSecond = previousSecond;
            wpm = 0;
            count = 0;
            characters = 0;
            drawStringEnabled = true;
            
            if (previousTime) {
                elapsedTime = tempSecond * 1000;
                
                secondString = String.format("%02d", tempSecond);
                timerLabel.setText(secondString);
                timerLabel.setVisible(true);
                
                time = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        elapsedTime -= 1000;
                        tempSecond = (elapsedTime / 1000) % 60;
                        if (elapsedTime < 1000) {
                            time.stop();
                        
                            wpm = ((correctCharacter / 5.0) / (double)previousSecond) * 60;
                            accuracy = (correctCharacter/count) * 100;
                            int temp4 = (int)wpm;
                            int temp3 = (int)accuracy;
                        
                            end = true;
                            running = false;
                            
                            try {
                                if (suddenDeath.isSelected()){
                                    database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                                }
                            } catch (Exception f){
                            }
                        
                            String temp = String.valueOf(temp4);
                            String temp2 = String.valueOf(temp3);

                            wpmScore.setText(temp);
                            accScore.setText(temp2+"%");
                            timerLabel.setVisible(false);
                        
                            repaint(); 
                        }
                        secondString = String.format("%02d", tempSecond);
                        timerLabel.setText(secondString);
                    }
                });
            }
            else if (previousWordOrQuote) {
                timer = 0;
                
                secondString = String.format("%02d", tempSecond);
                timerLabel.setText(secondString);
                timerLabel.setVisible(true);
                
                time = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        timer += 1000;
                        tempSecond = (timer / 1000);
                        if (count >= length) {
                            time.stop();
                        
                            wpm = ((correctCharacter / 5.0) / (double)tempSecond) * 60;
                            accuracy = (correctCharacter/(double)length) * 100;
                            int temp4 = (int)wpm;
                            int temp3 = (int)accuracy;
                        
                            end = true;
                            running = false;
                            
                            try {
                                if (suddenDeath.isSelected()){
                                    database.insertData("suddenDeath", signInFrame.username.getText().trim(), Double.toString(wpm), null);
                                }
                            } catch (Exception f){
                            }
                        
                            String temp = String.valueOf(temp4);
                            String temp2 = String.valueOf(temp3);

                            wpmScore.setText(temp);
                            accScore.setText(temp2+"%");
                            timerLabel.setVisible(false);
                        
                            repaint(); 
                        }
                        secondString = String.format("%02d", tempSecond);
                        timerLabel.setText(secondString);
                    }
                });
            }
            
            timerLabel.setVisible(true);
            source.setVisible(false);
            wpmLabel.setVisible(false);
            wpmScore.setVisible(false);
            accLabel.setVisible(false);
            accScore.setVisible(false);
            mispelledLabel.setVisible(false);
            listTable.setVisible(false);
            sourceLabel.setVisible(false);
            restartButton.setVisible(false);
            nextButton.setVisible(false);
            restartButton.setVisible(false);
            nextButton.setVisible(false);
            back.setEnabled(false);
            exit.setEnabled(false);
            
            checkbox.setEnabled(false);
            suddenDeath.setEnabled(false);
            correctionFacility.setEnabled(false);
            
            restartButton.removeActionListener(this);
            nextButton.removeActionListener(this);
            
            running = true;
            end = false;
            
            this.addKeyListener(this);
            
            revalidate();
            repaint();
        }
        else if (e.getSource() == nextButton) {
            
             
            if (suddenDeath.isSelected())
                correctionFacility.setEnabled(false);
            
            if (word.sizeCorrectioin() > 0) 
                correctionFacility.setEnabled(true);
            else
                correctionFacility.setEnabled(false);
            
            passageLine1 = "";
            passageLine2 = "";
            passageLine3 = "";
            passageLine4 = "";
            passageLine5 = "";
            passage = "";
            typePass = "";
            spaceWords = "";
            secondString = "";
            wrongWords = "";
            totalSecond = 0;
            secForButton1 = 15;
            secForButton2 = 30;
            secForButton3 = 45;
            secForButton4 = 60;
            lastSpaceCharacter = 0;
            elapsedTime = 0;
            accuracy = 0;
            correctCharacter = 0;
            length = 0;
            wpm = 0;
            count = 0;
            characters = 0;
            spaceCharacter = 0;
            option1 = false;
            option2 = false;
            option3 = false;
            option4 = false;
            drawStringEnabled = false;
            checkbox.setSelected(false);
            suddenDeath.setSelected(false);
            correctionFacility.setSelected(false);
            
            source.setVisible(false);
            wpmLabel.setVisible(false);
            wpmScore.setVisible(false);
            accLabel.setVisible(false);
            accScore.setVisible(false);
            mispelledLabel.setVisible(false);
            listTable.setVisible(false);
            sourceLabel.setVisible(false);
            restartButton.setVisible(false);
            nextButton.setVisible(false);
            suddenDeath.setVisible(true);
            correctionFacility.setVisible(true);
            
            timedMode.addActionListener(this);
            wordMode.addActionListener(this);
            quoteMode.addActionListener(this);
            restartButton.removeActionListener(this);
            nextButton.removeActionListener(this);
            this.remove(checkbox);
            
            timedMode.setForeground(new Color(0xBBBBBB));
            wordMode.setForeground(new Color(0xBBBBBB));
            quoteMode.setForeground(new Color(0xBBBBBB));
            timedMode.setEnabled(true);
            wordMode.setEnabled(true);
            quoteMode.setEnabled(true); 
            checkbox.setEnabled(true);
            suddenDeath.setEnabled(true);
      
            running = true;
            end = false;
            
            this.addKeyListener(this);
            
            revalidate();
            repaint();
        }
        if(running)
            repaint();
	if(end)
            repaint();
    }
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
	if (drawStringEnabled)
            draw(g);
 
    }
    
    public void draw(Graphics g){
        BufferedImage offScreenBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics offScreenGraphics = offScreenBuffer.getGraphics();
        
        offScreenGraphics.setFont(new Font("Consolas", Font.PLAIN, 16));
        offScreenGraphics.setColor(new Color(0x636568));
        
        g.setFont(new Font("Consolas", Font.PLAIN, 16));
        g.setColor(new Color(0x636568));
        
        if (running) {
            if (passage.length()>1) {
                
                secondLine = passageLine1.length() + passageLine2.length();
                thirdLine = secondLine + passageLine3.length();
                fourthLine = thirdLine + passageLine4.length();
                fifthLine = fourthLine + passageLine5.length();
                
                if (correctionFacility.isSelected()) {
                    if (option1) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*4, g.getFont().getSize()*28);
                    }
                    else if (option2) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*4, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4, g.getFont().getSize()*30);
                    }
                    else if (option3) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*4, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4, g.getFont().getSize()*30);
                        g.drawString(passage.substring(secondLine,thirdLine), g.getFont().getSize()*4, g.getFont().getSize()*32);
                    }
                    else if (option4) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*4, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4, g.getFont().getSize()*30);
                        g.drawString(passage.substring(secondLine,thirdLine), g.getFont().getSize()*4, g.getFont().getSize()*32);
                        g.drawString(passage.substring(thirdLine,fourthLine), g.getFont().getSize()*4, g.getFont().getSize()*34);
                        g.drawString(passage.substring(fourthLine,fifthLine), g.getFont().getSize()*4, g.getFont().getSize()*36);
                    }
                }
                else {
                    if (option1) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*5, g.getFont().getSize()*28);
                    }
                    else if (option2) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*5, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5, g.getFont().getSize()*30);
                    }
                    else if (option3) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*5, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5, g.getFont().getSize()*30);
                        g.drawString(passage.substring(secondLine,thirdLine), g.getFont().getSize()*5, g.getFont().getSize()*32);
                    }
                    else if (option4) {
                        g.drawString(passage.substring(0,passageLine1.length()), g.getFont().getSize()*5, g.getFont().getSize()*28);
                        g.drawString(passage.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5, g.getFont().getSize()*30);
                        g.drawString(passage.substring(secondLine,thirdLine), g.getFont().getSize()*5, g.getFont().getSize()*32);
                        g.drawString(passage.substring(thirdLine,fourthLine), g.getFont().getSize()*5, g.getFont().getSize()*34);
                        g.drawString(passage.substring(fourthLine,fifthLine), g.getFont().getSize()*5, g.getFont().getSize()*36);
                    }
                }
            }
            
            
            
            g.setFont(new Font("Consolas", Font.PLAIN, 16));
            
            
            if (correctionFacility.isSelected()) {
                if(option1) { 
                
                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*4, g.getFont().getSize() * 27+2, g.getFont().getSize()*4, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0 ) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                    }
                }
                else if(option2) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*4, g.getFont().getSize() * 27+2, g.getFont().getSize()*4, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize() 
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
                else if(option3) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*4, g.getFont().getSize() * 27+2, g.getFont().getSize()*4, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    *4+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    *4+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < secondLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > secondLine) {
                        if (characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
                if(option4) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*4, g.getFont().getSize() * 27+2, g.getFont().getSize()*4, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*4+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*4,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*4+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < secondLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*4,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > secondLine) {
                        if (characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,thirdLine), g.getFont().getSize()*4,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > thirdLine) {
                        if (characters < fourthLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(thirdLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(thirdLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(thirdLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-thirdLine)), g.getFont().getSize() * 33+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-thirdLine)), g.getFont().getSize() * 34+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine3.length()), g.getFont().getSize()*31+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(thirdLine,fourthLine), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(thirdLine,fourthLine), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(thirdLine,fourthLine), g.getFont().getSize()*4,g.getFont().getSize()*34);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()* 4+8.8 * (characters-thirdLine)), g.getFont().getSize() * 33+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-thirdLine)), g.getFont().getSize() * 34+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*4+8.8*passageLine3.length()), g.getFont().getSize()*31+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > fourthLine) {
                        if (characters < fifthLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(fourthLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(fourthLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(fourthLine,characters), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 35+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 36+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize() * 4+8.8 * passageLine4.length()), g.getFont().getSize()*33+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(fourthLine,fifthLine), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(fourthLine,fifthLine), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(fourthLine,fifthLine), g.getFont().getSize()*4,g.getFont().getSize()*36);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 4+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 35+2, (int)(g.getFont().getSize()
                                    * 4+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 36+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize() * 4+8.8 * passageLine4.length()), g.getFont().getSize()*33+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
            }
            else {
                if(option1) { 
                
                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*5, g.getFont().getSize() * 27+2, g.getFont().getSize()*5, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0 ) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                    }
                }
                else if(option2) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*5, g.getFont().getSize() * 27+2, g.getFont().getSize()*5, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize() 
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
                else if(option3) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*5, g.getFont().getSize() * 27+2, g.getFont().getSize()*5, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    *5+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    *5+8.8*characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < secondLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > secondLine) {
                        if (characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
                if(option4) {

                    if(characters == 0) {
                        g.setColor(Color.YELLOW);
                        g.drawLine(g.getFont().getSize()*5, g.getFont().getSize() * 27+2, g.getFont().getSize()*5, g.getFont().getSize() * 28+2);
                    }


                    if(typePass.length() > 0) {
                        if(characters < passageLine1.length()) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,characters), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()*5+8.8*characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(0,passageLine1.length()), g.getFont().getSize()*5,g.getFont().getSize()*28);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * characters), g.getFont().getSize() * 27+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * characters), g.getFont().getSize() * 28+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect(0, g.getFont().getSize() * 27+2, g.getFont().getSize()*5+1, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > passageLine1.length()) {
                        if(characters < secondLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),characters), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(passageLine1.length(),secondLine), g.getFont().getSize()*5,g.getFont().getSize()*30);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 29+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-passageLine1.length())), g.getFont().getSize() * 30+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine1.length()), g.getFont().getSize()*27+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > secondLine) {
                        if (characters < thirdLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(secondLine,thirdLine), g.getFont().getSize()*5,g.getFont().getSize()*32);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 31+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-secondLine)), g.getFont().getSize() * 32+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine2.length()), g.getFont().getSize()*29+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > thirdLine) {
                        if (characters < fourthLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(thirdLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(thirdLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(thirdLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-thirdLine)), g.getFont().getSize() * 33+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-thirdLine)), g.getFont().getSize() * 34+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine3.length()), g.getFont().getSize()*31+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(thirdLine,fourthLine), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(thirdLine,fourthLine), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(thirdLine,fourthLine), g.getFont().getSize()*5,g.getFont().getSize()*34);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize()* 5+8.8 * (characters-thirdLine)), g.getFont().getSize() * 33+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-thirdLine)), g.getFont().getSize() * 34+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize()*5+8.8*passageLine3.length()), g.getFont().getSize()*31+2, 300, g.getFont().getSize()+2);
                        }
                    }
                    if (typePass.length() > fourthLine) {
                        if (characters < fifthLine) {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(fourthLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(fourthLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(fourthLine,characters), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 35+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 36+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize() * 5+8.8 * passageLine4.length()), g.getFont().getSize()*33+2, 300, g.getFont().getSize()+2);
                        }
                        else {
                            g.setColor(new Color(0xCA4754));
                            g.drawString(wrongWords.substring(fourthLine,fifthLine), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(new Color(0x3BB143));
                            g.drawString(typePass.substring(fourthLine,fifthLine), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(new Color(0x7D2A33));
                            g.drawString(spaceWords.substring(fourthLine,fifthLine), g.getFont().getSize()*5,g.getFont().getSize()*36);
                            g.setColor(Color.YELLOW);
                            g.drawLine((int)(g.getFont().getSize() * 5+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 35+2, (int)(g.getFont().getSize()
                                    * 5+8.8 * (characters-thirdLine-passageLine4.length())), g.getFont().getSize() * 36+2);
                            g.setColor(new Color(0x333333));
                            g.fillRect((int)(g.getFont().getSize() * 5+8.8 * passageLine4.length()), g.getFont().getSize()*33+2, 300, g.getFont().getSize()+2);
                        }
                    }
                }
            }
     
            running=false; 
	}
        if(end){
            
            word.clearPassage();
            extraWordBackspace.clear();
            correctWordBackspace.clear();
            wrongWordBackspace.clear();
            pas.clear();
            pas2.clear();
            pas3.clear();
            pas4.clear();
            pas5.clear();
            
            timer1.removeActionListener(this);
            timer2.removeActionListener(this);
            timer3.removeActionListener(this);
            timer4.removeActionListener(this);
            timedMode.removeActionListener(this);
            wordMode.removeActionListener(this);
            quoteMode.removeActionListener(this);
            word1.removeActionListener(this);
            word2.removeActionListener(this);
            word3.removeActionListener(this);
            word4.removeActionListener(this);
            
            if (suddenDeath.isSelected()) {
                this.add(wpmLabel);
                this.add(wpmScore);
                sourceLabel.setBounds(394, 349, 84, 30);
                source.setBounds(492, 345, 600, 40);
                this.add(sourceLabel);
                this.add(source);
                accLabel.setVisible(false);
                accScore.setVisible(false);
            }
            else {
                this.add(wpmLabel);
                this.add(accLabel);
                this.add(wpmScore);
                this.add(accScore);
                sourceLabel.setBounds(394, 401, 84, 30);
                source.setBounds(492, 397, 600, 40);
                this.add(sourceLabel);
                this.add(source);
                accLabel.setVisible(true);
                accScore.setVisible(true);
            }
            
            this.add(restartButton);
            this.add(nextButton);
            
            source.setVisible(true);
            wpmLabel.setVisible(true);
            wpmScore.setVisible(true);
            sourceLabel.setVisible(true);
            restartButton.setVisible(true);
            nextButton.setVisible(true);
            mispelledLabel.setVisible(true);
            listTable.setVisible(true);
                    
            restartButton.addActionListener(this);
            nextButton.addActionListener(this);
            
            exit.setEnabled(true);
            back.setEnabled(true);
            
            this.removeKeyListener(this);
            revalidate();
            repaint();
            end=false;
        }
        
        g.drawImage(offScreenBuffer, 0, 0, this);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_ENTER) 
            return;
        
        if (passage.length()>1) {
            if (count == 0)
               time.start();
            else if (count == length) {
		end = true;
		running = false;
		count++;  
            }
            
            String [] correctionWords = passage.split(" ");
            
            if (!suddenDeath.isSelected()) {
                if (characters < length) {
                
                    running = true;
                    
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        if (characters == 0) 
                            return;
                    }
                    
                    if (characters == 0 && e.getKeyChar() == KeyEvent.VK_SPACE) 
                        word.getIncorrect(correctionWords[characters]);
                    
                    if (e.getKeyChar() == pass[characters] && e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_SPACE) {
                        correctWordBackspace.add(pass[characters]);
                        wrongWordBackspace.add(' ');
                        extraWordBackspace.add(' ');
                        typePass += pass[characters];
                        correctCharacter++;
                        spaceWords += (char)32;
                        wrongWords += (char)32;
                    }
                    else if (e.getKeyChar() != pass[characters] && e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_SPACE){
                        
                        if (!correctionFacility.isSelected())
                            word.getIncorrect(correctionWords[spaceCharacter]);

                        if (pass[characters] == 32){
                            spaceWords += e.getKeyChar();
                            extraWordBackspace.add(e.getKeyChar());
                            spaceCharacter++;
                        }
                        else {
                            extraWordBackspace.add(' ');
                            spaceWords += (char)32;
                        }
                        
                        wrongWordBackspace.add(pass[characters]);
                        correctWordBackspace.add(' ');
                        typePass += (char)32;
                        wrongWords += pass[characters];
                    }    
                
                    if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                        
                        int lastCharacters = length - lastSpaceCharacter;
                        if (characters == lastCharacters) {
                            
                            for (int i = 0; i < lastSpaceCharacter; i++) { 
                                correctWordBackspace.add(' ');
                                extraWordBackspace.add(' ');
                                wrongWordBackspace.add(pass[characters]);
                                spaceWords += (char)32;
                                typePass += (char)32;
                                wrongWords += pass[characters];
                                word.getIncorrect(correctionWords[spaceCharacter]);
                                count++;
                                characters++;
                            }
                        }
                        else if (pass[characters] == 32) {

                            spaceCharacter++;
                            correctCharacter++;
                            correctWordBackspace.add(' ');
                            extraWordBackspace.add(' ');
                            wrongWordBackspace.add(pass[characters]);
                            spaceWords += (char)32;
                            typePass += (char)32;
                            wrongWords += pass[characters];
                            
                        }
                        else {
                            
                            int characterIncrement = characters;
                            while (characterIncrement < length) {
                                
                                correctWordBackspace.add(' ');
                                extraWordBackspace.add(' ');
                                wrongWordBackspace.add(pass[characters]);
                                spaceWords += (char)32;
                                typePass += (char)32;
                                wrongWords += pass[characters];
                            
                                if (pass[characterIncrement] == 32) {
                                    if (!correctionFacility.isSelected())
                                        word.getIncorrect(correctionWords[spaceCharacter]);
                                    spaceCharacter++;
                                    break;
                                }
                                
                                characterIncrement++;
                                count++;
                                characters++;
                            }
                        }
                    }
                
                    characters++;
                    count++;
                
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        
                        typePass = "";
                        wrongWords = "";
                        spaceWords = "";
                        count -= 2;
                        characters -= 2;
                        if (correctCharacter > 0)
                            correctCharacter--;
                        
                        if (pass[characters] == 32) 
                            spaceCharacter--;

                        for (int i = 0; i < characters; i++) {
                            spaceWords += extraWordBackspace.get(i);
                            typePass += correctWordBackspace.get(i);
                            wrongWords += wrongWordBackspace.get(i);
                        }
                        extraWordBackspace.remove(characters);
                        correctWordBackspace.remove(characters);
                        wrongWordBackspace.remove(characters);
                    }
                    
                    repaint();
                }
            }
            else {
                if (characters < length) {
                    
                    running = true;
                
                    if (e.getKeyChar() == pass[characters] && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                        correctWordBackspace.add(pass[characters]);
                        extraWordBackspace.add(' ');
                        wrongWordBackspace.add(' ');
                        typePass += pass[characters];
                        correctCharacter++;
                        spaceWords += (char)32;
                        wrongWords += (char)32;
                    }
                    else if (e.getKeyChar() != pass[characters] && e.getKeyChar() != KeyEvent.VK_BACK_SPACE){
                        
                        if (pass[characters] == 32){
                            spaceWords += e.getKeyChar();
                            extraWordBackspace.add(e.getKeyChar());
                            spaceCharacter++;
                        }
                        else {
                            extraWordBackspace.add(' ');
                            spaceWords += (char)32;
                        }
                        
                        this.removeKeyListener(this);
                        wrongWordBackspace.add(pass[characters]);
                        correctWordBackspace.add(' ');
                        typePass += (char)32;
                        wrongWords += pass[characters];
                        count = length + 1;
                        elapsedTime = -1;
                    }    
                
                    characters++;
                    count++;
                
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        typePass = "";
                        wrongWords = "";
                        count -= 2;
                        characters -= 2;
                        for (int i = 0; i < characters; i++) {
                            spaceWords += extraWordBackspace.get(i);
                            typePass += correctWordBackspace.get(i);
                            wrongWords += wrongWordBackspace.get(i);
                        }
                        extraWordBackspace.remove(characters);
                        correctWordBackspace.remove(characters);
                        wrongWordBackspace.remove(characters);
                    }
                
                    repaint();
                }
            }
            mispelled = word.mostMispelledWord();
            while (list.getRowCount() > 0) {
                list.removeRow(0);
            }
            for (String word : mispelled){
                list.addRow(new Object[]{word});
            }
	}
        
    }    

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
