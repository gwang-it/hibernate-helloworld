import com.gwangit.model.User;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by gwang on 8/18/2016.
 */
public class FirstTest {
    @Test
    public void testSaveUser(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            User user = new User();
            user.setName("gwang");
            session.save(user);
            tx.commit();
        } catch(HibernateException he) {
            if(tx!=null) tx.rollback();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close ();
        }

    }
}
