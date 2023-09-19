package springbootrest.hello.helloworld.user;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private static int userCount =0;

    static{
        users.add(new User(++userCount,"Lakshmi", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"Kushank", LocalDate.now().minusYears(10)));
        users.add(new User(++userCount,"Sudhakar", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Roshini", LocalDate.now().minusYears(4)));
    }

    public List<User> findAll() {
        return users;
    }


    public User findOne(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        return users.stream().filter( userPredicate).findFirst().orElse(null);
    }

    public User createUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        users.remove(userPredicate);
    }
}
