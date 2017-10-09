package es.upm.miw.authentication.api.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.authentication.api.daos.UserDao;
import es.upm.miw.authentication.api.entities.User;

public class UserDaoMemory extends GenericDaoMemory<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);

    }
    
    @Override
    public User findUserByUserId(int userId) {
        List<User> users = this.findAll();
        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
            }
        }
        return user;
    }

}
