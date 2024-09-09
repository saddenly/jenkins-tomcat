import java.sql.*;

public class DbConnection {
    private static final String URL = "jdbc:postgresql://13.60.65.81:5432/mydatabase";
    private static final String USER = "rustem";
    private static final String PASS = "rustem";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}