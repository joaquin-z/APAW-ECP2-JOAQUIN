package es.upm.miw.authentication.api.controllers;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.memory.DaoMemoryFactory;

public class UserControllerIT {
    
    private UserController userController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        userController = new UserController();
        Calendar date = Calendar.getInstance();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        userController.createUser(1,"Joaquin",fecha,true);
    }

    @Test
    public void testCreateAndUserList() {
        Calendar date = Calendar.getInstance();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        userController.createUser(1,"Joaquin",fecha,true);
        assertEquals(2, userController.userList().size());
        assertEquals("Joaquin", userController.userList().get(0).getName());
    }
    
    
}
