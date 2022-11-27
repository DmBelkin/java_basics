
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;


public class Main {

    private static  final String url = "jdbc:mysql://localhost:3306/skillbox" +
            "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static final String user = "root";
    private static final String pass = "dima##skill**Box";

    public static void main(String[] args){
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                    configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory factory = metadata.getSessionFactoryBuilder().build();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Subscriptions> query = builder.createQuery(Subscriptions.class);
            Root<Subscriptions> root = query.from(Subscriptions.class);
            query.select(root);
            List<Subscriptions> list = session.createQuery(query).getResultList();

            for (Subscriptions subscriptions : list) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setCourseId(subscriptions.getCourseId().getId());
                linkedPurchaseList.setStudentId(subscriptions.getStudentId().getId());
                linkedPurchaseList.setPrice(subscriptions.getCourseId().getPrice());
                linkedPurchaseList.setSuscriptonDate(subscriptions.getSubscriptionsDate());
                System.out.println(linkedPurchaseList);
                session.persist(linkedPurchaseList);
            }
            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


