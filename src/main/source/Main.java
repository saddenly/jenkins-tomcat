import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DbConnection.getConnection()){
            UserDAO userDAO = new UserDAO();
            System.out.println(userDAO.getAllUsers());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}