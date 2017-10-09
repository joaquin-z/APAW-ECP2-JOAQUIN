package es.upm.miw.authentication;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.authentication.http.HttpException;
import es.upm.miw.authentication.api.daos.DaoFactory;
import es.upm.miw.authentication.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.authentication.api.resources.UserResource;
import es.upm.miw.authentication.http.HttpClientService;
import es.upm.miw.authentication.http.HttpMethod;
import es.upm.miw.authentication.http.HttpRequest;
import es.upm.miw.authentication.http.HttpRequestBuilder;

public class AuthenticationResourceFunctionalTesting {

    private Calendar date;
    
    private String fecha;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        new HttpRequest();
        date = Calendar.getInstance();
        fecha = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
    }
    
    public void createUser() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USERS).body("Joaquin:"+fecha).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateAuthentication() {
        this.createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("authentication").body("1:1").build();
        new HttpClientService().httpRequest(request);
    }    
    
    @Test
    public void testCreateAuthenticationUserNotFound() {
        exception.expect(HttpException.class);
        this.createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("authentication").body("0:1").build();
        new HttpClientService().httpRequest(request);
    }    

}
