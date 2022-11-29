import com.mysql.cj.jdbc.ClientPreparedStatement;import jakarta.persistence.criteria.CriteriaBuilder;import jakarta.persistence.criteria.CriteriaQuery;import jakarta.persistence.criteria.Root;import org.hibernate.*;import java.io.InputStream;import java.io.Reader;import java.math.BigDecimal;import java.net.URL;import java.sql.*;import org.hibernate.boot.Metadata;import org.hibernate.boot.MetadataSources;import org.hibernate.boot.registry.StandardServiceRegistry;import org.hibernate.boot.registry.StandardServiceRegistryBuilder;import org.hibernate.dialect.function.AggregateWindowEmulationQueryTransformer;import java.util.Calendar;import java.util.List;import java.util.stream.Collectors;public class Main {    public static void main(String[] args){        try {            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().                    configure("hibernate.cfg.xml").build();            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();            SessionFactory factory = metadata.getSessionFactoryBuilder().build();            Session session = factory.openSession();            Transaction transaction = session.beginTransaction();            CriteriaBuilder builder = session.getCriteriaBuilder();            CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);            Root<PurchaseList> root = query.from(PurchaseList.class);            query.select(root);            List<PurchaseList> list = session.createQuery(query).getResultList();            for (PurchaseList purchase : list) {                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();                String studentName = purchase.getStudentName();                Students student = getStudentByName(studentName, session, builder);                linkedPurchaseList.setStudentId(student.getId());                String courseName = purchase.getCourseName();                Course course = getCourseByName(courseName, session, builder);                System.out.println(course.getId());                linkedPurchaseList.setCourseId(course.getId());                linkedPurchaseList.setPrice(purchase.getPrice());                linkedPurchaseList.setSuscriptonDate(purchase.getSubscriptionDate());                session.persist(linkedPurchaseList);            }            transaction.commit();            session.close();            factory.close();        } catch (Exception ex) {            ex.printStackTrace();        }    }    private static Students getStudentByName(String studentName, Session session, CriteriaBuilder builder ) {        CriteriaQuery<Students> query = builder.createQuery(Students.class);        Root<Students> root = query.from(Students.class);        query.select(root);        List<Students> list = session.createQuery(query).getResultList();        return list.stream().filter(o -> o.getName().equals(studentName)).collect(Collectors.toList()).get(0);    }    private static Course getCourseByName(String courseName, Session session, CriteriaBuilder builder) {        CriteriaQuery<Course> query = builder.createQuery(Course.class);        Root<Course> root = query.from(Course.class);        query.select(root);        List<Course> list = session.createQuery(query).getResultList();        return list.stream().filter(o -> o.getName().equals(courseName)).collect(Collectors.toList()).get(0);    }}