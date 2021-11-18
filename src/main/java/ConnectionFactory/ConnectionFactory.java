package ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/primeiratabela", "MariaJulia", "M99905406");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
