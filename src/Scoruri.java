import java.sql.*;

public class Scoruri extends Baza {

    private static final String INSERT = "INSERT INTO scores(username, timp) VALUES (?, ?)";

    public boolean salvare(String username, long timp) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(INSERT)) {

            statement.setString(1, username);
            statement.setLong(2, timp);

            int rows = statement.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String clasament() {
        String SQL = "SELECT username, timp FROM scores ORDER BY timp ASC";
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(SQL);
             ResultSet rs = statement.executeQuery()) {

            int loc = 1;
            while (rs.next()) {
                sb.append(loc++)
                        .append(". ")
                        .append(rs.getString("username"))
                        .append(" - ")
                        .append(rs.getLong("timp") / 1000)
                        .append(" secunde\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}