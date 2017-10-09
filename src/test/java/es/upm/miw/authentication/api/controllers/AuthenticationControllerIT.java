package es.upm.miw.authentication.api.controllers;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.resources.exceptions.UserIdNotFoundException;

public class AuthenticationControllerIT {
    
 
    
    @Test
    public void testCreateAuthentication() throws UserIdNotFoundException {
        DaoFactory.setFactory(new DaoMemoryFactory());
        UserController userController = new UserController();
        Calendar date = Calendar.getInstance();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        userController.createUser("Joaquin",fecha);
        AuthenticationController authenticationController = new AuthenticationController();
        authenticationController.createAuthentication(1, Rol.ADMIN);
        assertEquals("Joaquin", authenticationController.userList().get(0).getUser().getName());
    }
}
