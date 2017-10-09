package es.upm.miw.authentication.api;

import es.upm.miw.authentication.api.entities.Rol;
import es.upm.miw.authentication.api.resources.AuthenticationResource;
import es.upm.miw.authentication.api.resources.UserResource;
import es.upm.miw.authentication.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.authentication.http.HttpRequest;
import es.upm.miw.authentication.http.HttpResponse;
import es.upm.miw.authentication.http.HttpStatus;

public class Dispatcher {
    
    UserResource userResource = new UserResource();
    AuthenticationResource authenticationResource = new AuthenticationResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(UserResource.USERS + UserResource.ID)) {
                response.setBody(userResource.readUser(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(UserResource.USERS)) {
                String name = request.getBody().split(":",-1)[0];
                String date = request.getBody().split(":",-1)[1];
                userResource.createUser(name, date);
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(AuthenticationResource.AUTHENTICATION)) {
                int userId = Integer.parseInt(request.getBody().split(":",-1)[0]);
                Rol rol = Rol.values()[Integer.parseInt((request.getBody().split(":",-1)[1]))];
                authenticationResource.createAuthentication(userId, rol);
                response.setStatus(HttpStatus.CREATED);
            } else{
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(UserResource.USERS + UserResource.ID)) {
                response.setStatus(HttpStatus.OK);
            } else{
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

}
