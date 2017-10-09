package es.upm.miw.authentication.api.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.dtos.UserDto;
import es.upm.miw.authentication.api.entities.User;

public class UserController {
    
    public List<UserDto> userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        List<UserDto> themeDtoList = new ArrayList<>();
        for (User user : userList) {
            themeDtoList.add(new UserDto(user));
        }
        return themeDtoList;
    }
    
    public void createUser(String name, String date) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1991,11,16);
        DaoFactory.getFactory().getUserDao().create(new User(name, birthday));
    }
    
    private boolean existUserId(int userId) {
        return DaoFactory.getFactory().getUserDao().read(userId) != null;
    }
    
    public Optional<UserDto> readUser(int userId) {
        if (existUserId(userId)) {
             return Optional.of(new UserDto(DaoFactory.getFactory().getUserDao().read(userId)));
         } else {
             return Optional.empty();
         }
     }

}
