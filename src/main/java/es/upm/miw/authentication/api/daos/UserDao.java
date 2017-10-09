package es.upm.miw.authentication.api.daos;

import es.upm.miw.authentication.api.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

    User findUserByUserId(int userId);
}
