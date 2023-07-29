import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/learn" +
            "?serverTimezone=UTC";
    private final String dbUser = "root";
    private final String dbPass = "dima##skill**Box";

    public DBConnection () {
        this.setConnection();
    }

    public Connection setConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, dbUser, dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id)," +
                        "UNIQUE KEY name_date(name(50), birthDate))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

}
