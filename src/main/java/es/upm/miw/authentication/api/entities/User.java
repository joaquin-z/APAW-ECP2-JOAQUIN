package es.upm.miw.authentication.api.entities;

import java.util.Calendar;

public class User {
    
    private int id;

    private String name;

    private Calendar birthday;

    private boolean active;
    
    public User(int id, String name, Calendar birthday, boolean active) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public boolean isActive() {
        return active;
    }    
    
}
