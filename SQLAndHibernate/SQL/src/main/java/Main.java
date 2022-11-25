
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args){
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                    configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory factory = metadata.getSessionFactoryBuilder().build();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            FileReader reader =
                    new FileReader("data/skillbox_sql_dump_2.sql");
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> collect = bufferedReader.lines().collect(Collectors.toList());
            String query = "";
            for (String str : collect) {
                if (str.equals("")) {
                    break;
                }
                query += str + "\n";
            }
            System.out.println(query);
            session.createQuery(query, Course.class);
            transaction.commit();
            session.close();
            factory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


