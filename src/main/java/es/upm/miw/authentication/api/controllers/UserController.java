package es.upm.miw.authentication.api.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    
    public void createUser(int id, String name, Calendar birthday, boolean active) {
        DaoFactory.getFactory().getUserDao().create(new User(id, name, birthday, active));
    }

}
