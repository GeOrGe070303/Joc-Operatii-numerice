import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baza extends Cont {
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                dateconectare.LOCALIZARE,
                dateconectare.NUMEUTILIZATOR,
                dateconectare.PAROLA
        );
    }
}