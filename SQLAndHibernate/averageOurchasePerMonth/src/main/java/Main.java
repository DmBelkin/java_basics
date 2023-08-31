import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox" +
                "?serverTimezone=UTC";
        String user = "root";
        String pass = "dima##skill**Box";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            HashMap<String, List<Purchase>> purchaseList = new HashMap<>();
            ResultSet set = statement.executeQuery("SELECT name FROM skillbox.courses");
            while (set.next()) {
                purchaseList.put(set.getString("name"), new ArrayList<>());
            }

            ResultSet resultset =
                    statement.
                            executeQuery("SELECT course_name, subscription_date FROM skillbox.purchaselist " +
                                    "WHERE subscription_date " +
                                    "BETWEEN '2018-01-01' AND '2018-12-30'");

            while (resultset.next()) {
                String subscriptionDate = resultset.getString("subscription_date");
                String coursename = resultset.getString("course_name");
                for (Map.Entry<String, List<Purchase>> map : purchaseList.entrySet()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    if (map.getKey().equals(coursename)) {
                        map.getValue().add(new Purchase(LocalDateTime.parse(subscriptionDate, formatter),
                                coursename));
                    }
                }
            }
            for (Map.Entry<String, List<Purchase>> map : purchaseList.entrySet()) {
                Collections.sort(map.getValue());
                if (map.getValue().size() != 0) {
                    double zone = map.getValue().get(map.getValue().size() - 1).
                            getSubscriptionsDate().getMonth().getValue() -
                            map.getValue().get(0).getSubscriptionsDate().getMonth().getValue();
                    double average =  map.getValue().size() / zone;
                    System.out.println(map.getKey() + "-" + "в среднем за мес€ц: " +
                            average);
                } else {
                    System.out.println(map.getKey() + "-" + "в среднем за мес€ц: " + 0);
                }
            }
            resultset.close();
            statement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
