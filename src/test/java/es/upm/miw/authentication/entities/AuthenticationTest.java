package es.upm.miw.authentication.entities;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.entities.User;

public class AuthenticationTest {

    @Test
    public void testNewUser() {
        Calendar date = Calendar.getInstance();
        date.set(1991,11,16);
        User user = new User(1,"Joaquin",date,true);
        Authentication authentication = new Authentication(1,user,Rol.ADMIN);
        assertEquals(1, authentication.getId());
    }
}
