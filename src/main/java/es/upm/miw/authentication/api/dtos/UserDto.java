package es.upm.miw.authentication.api.dtos;

import java.util.Calendar;

import es.upm.miw.authentication.api.entities.User;

public class UserDto {
    
    private int id;

    private String name;

    private boolean active;

    private Calendar birthday;

    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        birthday = user.getBirthday();
        active = user.isActive();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + ",\"birthday\":\"" + birthday + ",\"active\":\"" + active + "\"}";
    }

}
