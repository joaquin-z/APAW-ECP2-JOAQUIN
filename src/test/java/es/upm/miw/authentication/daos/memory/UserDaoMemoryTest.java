package es.upm.miw.authentication.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.authentication.api.entities.User;

public class UserDaoMemoryTest {

    private User user;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        Calendar date = Calendar.getInstance();
        date.set(1991,11,16);
        user = new User(1, "Joaquin", date, true);
        DaoFactory.getFactory().getUserDao().create(user);
    }

    @Test
    public void testReadUser() {
        assertEquals("Joaquin", DaoFactory.getFactory().getUserDao().read(1).getName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getUserDao().read(2));
    }

}
