package application.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/jotly_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "Daven*0912406761810"; // your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
