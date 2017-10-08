package es.upm.miw.authentication.api.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.authentication.api.daos.AuthenticationDao;
import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;

public class AuthenticationDaoMemory extends GenericDaoMemory<Authentication> implements AuthenticationDao {

    public AuthenticationDaoMemory() {
        this.setMap(new HashMap<Integer, Authentication>());
    }

    @Override
    protected Integer getId(Authentication entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Authentication entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public Rol findRolByUserId(int userId) {
        List<Authentication> authentications = this.findAll();
        Rol authenticationsRol = null;
        for (Authentication authentication : authentications) {
            if (authentication.getUser().getId() == userId) {
                authenticationsRol = authentication.getRol();
            }
        }
        return authenticationsRol;
    }

}
