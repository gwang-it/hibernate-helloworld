import com.gwangit.dao.impl.UserDaoImpl;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by wgz on 8/14/2016.
 */
public class AppTest {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void testsave(){
        Session session = null;
        Transaction tx = null;
        session = userDao.getCurrentSession();
        tx = session.getTransaction();

        try{
            tx.begin();
            User user = new User();
            user.setName("gwang");
            userDao.create(user);
            tx.commit();
        }catch (final HibernateException he){
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }catch (final Exception e){
            e.printStackTrace();
        }

    }
}
