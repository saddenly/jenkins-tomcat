import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UserDAO {
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users(first_name, last_name, age) VALUES (?, ?, ?)";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setInt(3, user.getAge());

            stmt.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(query)) {
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAge(result.getInt("age"));

                users.add(user);
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET first_name = ?, last_name = ?, age = ? WHERE id = ?";

        try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setInt(3, user.getAge());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        }
    }
}