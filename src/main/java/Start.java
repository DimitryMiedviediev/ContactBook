import java.sql.Connection;

import static DBC.DBConnection.getConnection;
import static DBC.DBConnection.stopConnection;

public class Start {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection connection = getConnection();
        stopConnection(connection);
    }
}
