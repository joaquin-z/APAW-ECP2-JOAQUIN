package es.upm.miw.authentication.daos.memory;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.entities.User;

public class AuthenticationDaoMemoryTest {

    private User user;

    private Authentication authentication;
    
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        Calendar date = Calendar.getInstance();
        date.set(1991,11,16);
        user = new User(1,"Joaquin",date,true);
        authentication = new Authentication(1, user, Rol.ADMIN);
        DaoFactory.getFactory().getAuthenticationDao().create(authentication);

    }

    @Test
    public void testFindRolByUserId() {
        assertEquals(Rol.ADMIN, DaoFactory.getFactory().getAuthenticationDao().findRolByUserId(user.getId()));
    }

    @Test
    public void testCreatedRead() {
        assertEquals(Rol.ADMIN, DaoFactory.getFactory().getAuthenticationDao().read(authentication.getId()).getRol());
    }

    @Test
    public void testUpdate() {
        authentication.setRol(Rol.CUSTOMER);
        DaoFactory.getFactory().getAuthenticationDao().update(authentication);
        assertEquals(Rol.CUSTOMER, DaoFactory.getFactory().getAuthenticationDao().read(authentication.getId()).getRol());
    }

    @Test
    public void testDeleteById() {
        DaoFactory.getFactory().getAuthenticationDao().deleteById(authentication.getId());
        assertNull(DaoFactory.getFactory().getAuthenticationDao().read(authentication.getId()));
    }

    @Test
    public void testFindAll() {
        DaoFactory.getFactory().getAuthenticationDao().create(new Authentication(4, user, Rol.OPERATION));
        assertEquals(2, DaoFactory.getFactory().getAuthenticationDao().findAll().size());
    }

}
