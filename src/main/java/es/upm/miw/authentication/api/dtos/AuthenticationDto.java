package es.upm.miw.authentication.api.dtos;

import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.entities.User;

public class AuthenticationDto {

    private User user;

    private Rol rol;

    public AuthenticationDto() {
    }

    public AuthenticationDto(Authentication authentication) {
        this.user = authentication.getUser();
        this.rol = authentication.getRol();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "{\"user\":\"" + user + ",\"rol\":" + rol + "}";
    }

}
