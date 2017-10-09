package es.upm.miw.authentication.api.controllers;


import java.util.ArrayList;
import java.util.List;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.dtos.AuthenticationDto;
import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.entities.User;
import es.upm.miw.authentication.api.resources.exceptions.UserIdNotFoundException;

public class AuthenticationController {

    public void createAuthentication(int userId, Rol rol) throws UserIdNotFoundException {
        if (existUserId(userId)) {
            User user = DaoFactory.getFactory().getUserDao().findUserByUserId(userId);
            DaoFactory.getFactory().getAuthenticationDao().create(new Authentication(user, rol));
        }     else {
            throw new UserIdNotFoundException(String.valueOf(userId));
        }
    }
    
    public List<AuthenticationDto> userList() {
        List<Authentication> authenticationList = DaoFactory.getFactory().getAuthenticationDao().findAll();
        List<AuthenticationDto> authenticationDtoList = new ArrayList<>();
        for (Authentication authentication : authenticationList) {
            authenticationDtoList.add(new AuthenticationDto(authentication));
        }
        return authenticationDtoList;
    }
    
    private boolean existUserId(int userId) {
        return DaoFactory.getFactory().getUserDao().read(userId) != null;
    }

}
