import java.sql.*;

public class User extends Baza {

    private static final String REGISTER = "INSERT INTO users(username, password) VALUES (?, ?)";
    private static final String LOGIN = "SELECT 1 FROM users WHERE username = ? AND password = ?";

    public boolean register() {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(REGISTER)) {

            statement.setString(1, getUsername());
            statement.setString(2, getPassword());

            int input = statement.executeUpdate();
            return input > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean login() {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(LOGIN)) {

            statement.setString(1, getUsername());
            statement.setString(2, getPassword());

            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}