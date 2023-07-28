import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DBConnection {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/learn" +
            "?serverTimezone=UTC";
    private final String dbUser = "root";
    private final String dbPass = "dima##skill**Box";
    private final StringBuilder insertQuery = new StringBuilder();

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

    public void execute() throws SQLException {
        String sql = "INSERT INTO voter_count (name, birthDate, `count`)" +
                " VALUES" + insertQuery.toString() +
                "ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        connection.createStatement().executeUpdate(sql);
    }

    public void countVoter(String name, String birthDay) throws SQLException {
        boolean isStart = insertQuery.length() == 0;
        insertQuery.append((isStart? "": ",") + "('" + name + "', '" + birthDay + "',1)");
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
