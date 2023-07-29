import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Insertexecutor {

    private Connection connection;

    private List<Voter> voters;

    private final StringBuilder insertQuery = new StringBuilder();


    public Insertexecutor(Connection connection, List<Voter> voters) {
        this.connection = connection;
        this.voters = voters;
        try {
            add();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add() throws SQLException{
        for (Voter voter : voters) {
            countVoter(voter.getName(), voter.getBirthDay().toString());
        }
    }

    public void countVoter(String name, String birthDay) throws SQLException {
        boolean isStart = insertQuery.length() == 0;
        insertQuery.append((isStart? "": ",") + "('" + name + "', '" + birthDay + "',1)");
    }

    public void execute() throws SQLException {
        String sql = "INSERT INTO voter_count (name, birthDate, `count`)" +
                " VALUES" + insertQuery +
                "ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        connection.createStatement().executeUpdate(sql);
    }
}
