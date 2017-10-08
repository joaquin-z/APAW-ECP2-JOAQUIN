package es.upm.miw.authentication.api;

import es.upm.miw.authentication.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.authentication.http.HttpRequest;
import es.upm.miw.authentication.http.HttpResponse;
import es.upm.miw.authentication.http.HttpStatus;

public class Dispatcher {

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        response.setStatus(HttpStatus.CREATED);
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

}
