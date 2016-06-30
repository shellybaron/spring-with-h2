package dao;

import model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sbaron
 * @since 6/30/16
 */
@Component
public interface UserDao {

    List<User> getUsers();

}
