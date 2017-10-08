package es.upm.miw.authentication.api.resources;

import es.upm.miw.authentication.api.controllers.UserController;
import es.upm.miw.authentication.api.resources.exceptions.DateEmptyException;
import es.upm.miw.authentication.api.resources.exceptions.NameEmptyException;

public class UserResource {
    
    public static final String USERS = "users";
    
    public void createUser(String name, String date ) throws DateEmptyException, NameEmptyException {
        if (name.isEmpty()) {
            throw new NameEmptyException(name);
        }
        if (date.isEmpty()) {
            throw new DateEmptyException(date);
        }
        new UserController().createUser(name, date);
    }

}
