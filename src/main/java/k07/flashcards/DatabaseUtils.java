package k07.flashcards;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtils {
    private static Connection connection = null;

    public static boolean login(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                return true;
            } else {
                System.out.println("Failed to make connection!");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static CharacterTuple getInfoFromTable(String tableName) {
        String query = "SELECT * FROM Flashcards";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String character = rs.getString("front");
                String meaning = rs.getString("meaning");
                return new CharacterTuple(character, meaning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
