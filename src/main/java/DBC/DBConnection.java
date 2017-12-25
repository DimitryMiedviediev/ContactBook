package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String SCHEMA_NAME = "contactbook";
    private static final String HOST = "188.166.171.33";
    private static final String USERNAME = "contactbook";
    private static final String PASSWORD = "contactbook42";
    private static final String URL = "jdbc:mysql://" + HOST + ":3306/" + SCHEMA_NAME + "?useSSL=false&amp;characterEncoding=utf8&amp;useUnicode=yes";

    public static String getSchemaName() {
        return SCHEMA_NAME;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public static void stopConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
