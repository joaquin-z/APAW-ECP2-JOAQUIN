package es.upm.miw.authentication.entities;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.authentication.api.entities.User;

public class UserTest {

    @Test
    public void testNewUser() {
        Calendar date = Calendar.getInstance();
        date.set(1991,11,16);
        User user = new User(1,"Joaquin",date,true);
        assertEquals("Joaquin", user.getName());
    }
}
