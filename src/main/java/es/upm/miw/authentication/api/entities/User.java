package es.upm.miw.authentication.api.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {
    
    private int id;

    private String name;

    private Calendar birthday;

    private boolean active;
    
    public User(String name, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public User(int id, String name, Calendar birthday, boolean active) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.active = active;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    @Override
    public String toString() {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(birthday.getTime());
        return "User [id=" + id + ", name=" + name + ", birthday=" + formattedDate + ", active=" + active + "]";
    }
    
}
