package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER = "SQL_SELECT";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
}
