package es.upm.miw.authentication.api.daos.memory;

import es.upm.miw.authentication.api.daos.AuthenticationDao;
import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.UserDao;

public class DaoMemoryFactory extends DaoFactory {

    private UserDao userDao;

    private AuthenticationDao authenticationDao;

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

    @Override
    public AuthenticationDao getAuthenticationDao() {
        if (authenticationDao == null) {
            authenticationDao = new AuthenticationDaoMemory();
        }
        return authenticationDao;
    }

}
