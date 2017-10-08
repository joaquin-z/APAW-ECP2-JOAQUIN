package es.upm.miw.authentication.api.daos.memory;

import java.util.HashMap;

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

}
