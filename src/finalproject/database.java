package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class database {
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/users";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void createTable() throws Exception{
        try{
            Connection connection = getConnection();
            String statement = "CREATE TABLE IF NOT EXISTS userlist"
                    + "(id INT PRIMARY KEY AUTO_INCREMENT, Username VARCHAR(255) COLLATE utf8_bin, Password VARCHAR(255) COLLATE utf8_bin)";
            PreparedStatement create = connection.prepareStatement(statement);
            statement = "CREATE TABLE IF NOT EXISTS result"
                    + "(id INT PRIMARY KEY AUTO_INCREMENT, Username VARCHAR(255) COLLATE utf8_bin,WPM FLOAT, Accuracy FLOAT)";
            PreparedStatement create1 = connection.prepareStatement(statement);
            statement = "CREATE TABLE IF NOT EXISTS leaderboard"
                    + "(id INT PRIMARY KEY AUTO_INCREMENT,Username VARCHAR(255) COLLATE utf8_bin,AvWpmLast10 FLOAT)";
            PreparedStatement create2 = connection.prepareStatement(statement);
            statement = "CREATE TABLE IF NOT EXISTS misspelled"
                    + "(id INT PRIMARY KEY AUTO_INCREMENT,Username VARCHAR(255) COLLATE utf8_bin,"
                    + "Word VARCHAR(255) COLLATE utf8_bin, Frequency INT)";
            PreparedStatement create3 = connection.prepareStatement(statement);
            statement = "CREATE TABLE IF NOT EXISTS suddenDeath"
                    + "(id INT PRIMARY KEY AUTO_INCREMENT,Username VARCHAR(255) COLLATE utf8_bin,Score FLOAT)";
            PreparedStatement create4 = connection.prepareStatement(statement);
            create.executeUpdate();
            create1.executeUpdate();
            create2.executeUpdate();
            create3.executeUpdate();
            create4.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static boolean readDatabase(String user, String password) throws Exception{
        try {
            Connection connection = getConnection();
            String statement;
            //readDatabase(username, password)
            if (user!=null && password!=null)
                statement = "SELECT * FROM userlist WHERE Username = '"+user+"' AND Password = '"+password+"'";
            //readDatabase(username, null)
            else if(password==null)
                statement = "SELECT * FROM userList WHERE Username = '"+user+"'";
            //readDatabase(null, password)
            else 
                statement = "SELECT * FROM userList WHERE Password = '"+password+"'";
            PreparedStatement search = connection.prepareStatement(statement);
            ResultSet result = search.executeQuery();
            if (result.next())
                return true;
            else
                return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public static void insertData(String a, String b, String c, String d) throws Exception{
        try{
            Connection connection = getConnection();
            String statement ="";
            int frequency=1;
            switch(a){
                //insertData("userlist", username, password, null)
                case "userlist":
                    statement = "SELECT * FROM userlist WHERE Username ='"+b+"'";
                    PreparedStatement check = connection.prepareStatement(statement);
                    ResultSet result = check.executeQuery();
                    if (result.next())
                        return;
                    else 
                        statement = "INSERT INTO userlist (Username, Password) VALUES ('"+b+"','"+c+"')";
                    break;
                
                //insertData("result", username, Double.toString(wpm), Double.toString(accuracy))
                case "result":
                    statement="INSERT INTO result (Username,Wpm, Accuracy) VALUES ('"+b+"',?,?)";
                    break;
                    
                //insertData("misspelled", username, word, null)
                case "misspelled":
                    statement = "SELECT * FROM misspelled WHERE Username ='"+b+"' AND Word ='"+c+"'";
                    PreparedStatement check1 = connection.prepareStatement(statement);
                    ResultSet result1 = check1.executeQuery();
                    if (result1.next()){
                        frequency = result1.getInt("Frequency") +1;
                        statement = "UPDATE misspelled SET Frequency= ? WHERE Username ='"+b+"' AND Word ='"+c+"'";
                    }
                    else
                        statement="INSERT INTO misspelled (Username,Word, Frequency) VALUES ('"+b+"','"+c+"', ?)";
                    break;
                
                //insertData("suddenDeath", username, Double.toString(suddenDeathScore), null)
                case "suddenDeath":
                    statement = "INSERT INTO suddenDeath (Username,Score) VALUES (?,?)";
                    break;
            }            
            PreparedStatement insert = connection.prepareStatement(statement);
            if (a.equals("result")){
                insert.setFloat(1,Float.parseFloat(c));
                insert.setFloat(2,Float.parseFloat(d));
            }
            else if (a.equals("suddenDeath")){
                insert.setString(1,b);
                insert.setFloat(2,Float.parseFloat(c));
            }
            else if(a.equals("misspelled"))
                insert.setInt(1,frequency);
            insert.executeUpdate();
        }      
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static String calculateAverage(String mode, String choice, String user) throws Exception{
        try{
            float average;
            String statement;
            Connection connection = getConnection();
            statement = "SELECT * FROM userlist WHERE Username = '"+user+"'";
            PreparedStatement userExist1 = connection.prepareStatement(statement);
            ResultSet userExist = userExist1.executeQuery();
            if (userExist.next()){
                if (mode.equals("allTime"))
                    statement = "SELECT AVG("+choice+")AS AVG FROM result WHERE Username = '"+user+"'";
                else
                    statement = "SELECT AVG("+choice+") as AVG FROM(SELECT "+choice+" FROM result WHERE Username='"+user+"' ORDER BY id DESC LIMIT 10) AS subquery";
                    PreparedStatement calculate = connection.prepareStatement(statement);
                    ResultSet result = calculate.executeQuery();

                if (!result.next())
                    average = 0;
                else
                   average = result.getFloat("AVG");

                if (mode.equals("last10")&&choice.equals("WPM")){
                    statement = "SELECT * FROM leaderboard WHERE Username = '"+user+"'";
                    PreparedStatement check = connection.prepareStatement(statement);
                    ResultSet result1 = check.executeQuery();
                    if (result1.next()){
                        statement = "UPDATE leaderboard SET AvWpmLast10=? WHERE Username = ?";
                        PreparedStatement update = connection.prepareStatement(statement);
                        update.setFloat(1, average);
                        update.setString(2, user);
                        update.executeUpdate();
                    }
                    else{
                        //column AvWpmLast10 is in float datatype
                        statement="INSERT INTO leaderboard (Username, AvWpmLast10) VALUES (?,?)";
                        PreparedStatement insert = connection.prepareStatement(statement);
                        insert.setString(1, user);
                        insert.setFloat(2, average);
                        insert.executeUpdate();
                    }
                }
                return Float.toString(average);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static LinkedHashMap<String,String> sort(String mode, String username) throws Exception{
        LinkedHashMap <String, String> selected = new LinkedHashMap();
        String key="", value="", statement="";
        try{
            Connection connection = getConnection();
            switch(mode) {
                //sort("leaderboard", null)
                case "leaderboard":
                    statement = "SELECT * FROM leaderboard ORDER BY AvWpmLast10 DESC LIMIT 10";
                    key = "Username";
                    value = "AvWpmLast10";
                    break;
                
                //sort("misspelled", username)
                case "misspelled":
                    statement = "SELECT * FROM misspelled WHERE Username = '"+username+"' ORDER BY Frequency DESC LIMIT 10";
                    key = "Word";
                    value = "Frequency";
                    break;
                
                //sort("suddenDeath", username)
                case "suddenDeath":
                    statement = "CREATE TEMPORARY TABLE temp AS SELECT Username, Score FROM suddenDeath WHERE Username = '"+username+"'";
                    PreparedStatement select = connection.prepareStatement(statement);
                    select.executeUpdate();
                    statement = "ALTER TABLE temp ADD id INT PRIMARY KEY AUTO_INCREMENT";
                    PreparedStatement add = connection.prepareStatement(statement);
                    add.executeUpdate();
                    key = "id";
                    value = "Score";
                    statement = "SELECT * FROM temp ORDER BY id DESC";
                    break;                
            }
            PreparedStatement sort = connection.prepareStatement(statement);
            ResultSet result = sort.executeQuery();
            while (result.next()){
                selected.put(result.getString(key),
                        String.valueOf(mode.equals("misspelled")?result.getInt(value):result.getFloat(value)));
            }                            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selected;
    }
    
    public static ArrayList<String> getMisspelledWords(String user) throws Exception{
        ArrayList<String> misspelledWords = new ArrayList();
        try{
            Connection connection = getConnection();
            String statement = "Select * FROM misspelled WHERE Username = '"+user+"'";
            PreparedStatement get = connection.prepareStatement(statement);
            ResultSet result = get.executeQuery();
            while(result.next())
                misspelledWords.add(result.getString("Word"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return misspelledWords;
    }
}