package es.upm.miw.authentication.api.resources;

import java.util.Optional;

import es.upm.miw.authentication.api.controllers.UserController;
import es.upm.miw.authentication.api.dtos.UserDto;
import es.upm.miw.authentication.api.resources.exceptions.DateEmptyException;
import es.upm.miw.authentication.api.resources.exceptions.NameEmptyException;
import es.upm.miw.authentication.api.resources.exceptions.UserIdNotFoundException;
import es.upm.miw.authentication.api.resources.exceptions.UserInvalidException;

public class UserResource {
    
    public static final String USERS = "users";
    
    public static final String ID = "/{id}";
    
    public void createUser(String name, String date ) throws DateEmptyException, NameEmptyException {
        if (name.isEmpty()) {
            throw new NameEmptyException(name);
        }
        if (date.isEmpty()) {
            throw new DateEmptyException(date);
        }
        new UserController().createUser(name, date);
    }
    
    public UserDto readUser(int userId) throws UserIdNotFoundException, UserInvalidException {
        if (userId < 0 || userId > Integer.MAX_VALUE) {
            throw new UserInvalidException(userId);
        }
        Optional<UserDto> optional = new UserController().readUser(userId);
        return optional.orElseThrow(() -> new UserIdNotFoundException(Integer.toString(userId)));
    }
    
    public void deleteUser(int userId) {
        new UserController().deleteUser(userId);
    }

}
