package es.upm.miw.authentication.api.daos;

import es.upm.miw.authentication.api.entities.Authentication;
import es.upm.miw.authentication.api.entities.Rol;

public interface AuthenticationDao extends GenericDao<Authentication, Integer> {

    Rol findRolByUserId(int userId);
}
