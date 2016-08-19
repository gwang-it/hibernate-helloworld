import com.gwangit.dao.impl.UserDaoImpl;
import com.gwangit.dao.inter.UserDaoInter;
import com.gwangit.model.User;
import com.gwangit.service.impl.UserServiceImpl;
import com.gwangit.service.inter.UserServiceInter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by wgz on 8/14/2016.
 */
public class AppTest {
    private UserServiceInter userService = new UserServiceImpl();


    @Test
    public void testSaveUser(){
        User user = new User();
        user.setName("gwangit");
        userService.create(user);
    }

    @Test
    public void testFindAllUser(){
        List<User> list = userService.findAll();
        for (User user: list) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testFindUserById(){
        User user = userService.findOne(6L);
        System.out.println(user.getName());
    }

    @Test
    public void testUpdateUser(){
        User user = userService.findOne(6L);
        user.setName("Peter");
        userService.update(user);
    }

    @Test
    public void testDeleteUser(){
        User user = userService.findOne(6L);
        userService.delete(user);
    }

    @Test
    public void findUserByName(){
        List<User> users = userService.findUserByName("gwang");
        for (User user : users){
            System.out.println(user.getId());
        }
    }
}
