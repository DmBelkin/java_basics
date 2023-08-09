
import org.redisson.api.RScoredSortedSet;

import java.time.LocalDate;
import java.util.Random;

public class RedisTest {

    private static final Random random = new Random();

    public static void main(String[] args) {
        RedisStorage storage = new RedisStorage();
        userFabric(storage);
        RScoredSortedSet<User> sortedSet = storage.getOnlineUsers();
        try {
            siteEmulator(sortedSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.shutdown();
    }

    public static void userFabric(RedisStorage storage) {
        storage.init();
        for (int i = 0; i <= 20; i++) {
            int registrationDay = (int) (i * Math.random());
            LocalDate registrationDate = LocalDate.now().plusDays(registrationDay);
            User user = new User(registrationDate, registrationDay);
            storage.logPageVisit(user.getUserId(), user);
        }
    }

    public static void siteEmulator(RScoredSortedSet<User> sortedSet) throws InterruptedException {
        while (true) {
            for (User user : sortedSet) {
                User donatUser = pay(sortedSet);
                if (donatUser.isDonate()) {
                    System.out.println("mainPage:{ " + donatUser + "}");
                    Thread.sleep(100);
                }
                if (donatUser.getUserId() != user.getUserId()) {
                    System.out.println("mainPage:{ " + user + "}");
                    Thread.sleep(100);
                }
            }
        }
    }

    public static User pay(RScoredSortedSet<User> sortedSet) {
        int stop = (int)(sortedSet.size() * Math.random());
        int index = 0;
        for (User user : sortedSet) {
            if (index == stop) {
                user.setDonate(random.nextBoolean());
                return user;
            }
            index++;
        }
        return new User();
    }
}
