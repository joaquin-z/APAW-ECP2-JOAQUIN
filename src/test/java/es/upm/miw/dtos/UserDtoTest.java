package es.upm.miw.dtos;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.authentication.api.dtos.AuthenticationDto;
import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.entities.User;

public class UserDtoTest {

    @Test
    public void testNewUserDto() {
        Calendar date = Calendar.getInstance();
        date.set(1991,11,16);
        User user = new User(1,"Joaquin",date,true);
        Authentication authentication = new Authentication(1,user,Rol.ADMIN);
        AuthenticationDto authenticationDto = new AuthenticationDto(authentication);
        assertEquals(1, authenticationDto.getUser().getId());
    }

}
