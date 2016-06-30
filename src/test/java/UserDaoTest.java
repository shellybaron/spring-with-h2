import dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.assertEquals;

/**
 * @author sbaron
 * @since 6/30/16
 */
public class UserDaoTest {

    ClassPathXmlApplicationContext context;
    UserDao userDao;

    @Before
    public void loadApplicationContextWithTestProfile() {
        context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath:spring/app-context.xml");
        context.getEnvironment().setActiveProfiles("test");
        context.refresh();
    }

    @Test
    public void testH2Connection() {
        userDao = (UserDao) context.getBean("userDao");
        assertEquals(userDao.getUsers().size(), 3);
    }

    @After
    public void close() {
        context.close();
    }

}
