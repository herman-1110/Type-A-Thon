package finalproject;

public class TypeAThon {
    public static void main(String[] args) {
        signInFrame.getInstance();
        try {
            database.createTable();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}  