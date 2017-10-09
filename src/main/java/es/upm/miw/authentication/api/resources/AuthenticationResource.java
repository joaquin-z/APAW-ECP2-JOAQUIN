package es.upm.miw.authentication.api.resources;

import es.upm.miw.authentication.api.controllers.AuthenticationController;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.resources.exceptions.UserIdNotFoundException;

public class AuthenticationResource {
    
    public static final String AUTHENTICATION = "authentication";
    
    public static final String ID = "/{id}";
    
    public void createAuthentication(int userId, Rol rol ) throws UserIdNotFoundException {
        new AuthenticationController().createAuthentication(userId, rol);
    }

}
