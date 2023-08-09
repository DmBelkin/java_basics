
import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisStorage {
    // ������ ��� ������ � Redis
    private RedissonClient redisson;

    // ������ ��� ������ � �������
    private RKeys rKeys;

    // ������ ��� ������ � Sorted Set'��
    private RScoredSortedSet<User> onlineUsers;

    private final static String KEY = "ONLINE_USERS";

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("�� ������� ������������ � Redis");
            System.out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    // ��������� ��������� ������������� ��������
    void logPageVisit(double userId, User user)
    {
        //ZADD ONLINE_USERS
        onlineUsers.add(userId, user);
    }

    public RScoredSortedSet<User> getOnlineUsers() {
        return onlineUsers;
    }

}
