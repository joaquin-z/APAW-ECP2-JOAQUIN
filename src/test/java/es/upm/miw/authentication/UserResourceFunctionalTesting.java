package es.upm.miw.authentication;

import static org.junit.Assert.assertEquals;

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

public class UserResourceFunctionalTesting {

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
    public void testCreateUser() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USERS).body("Joaquin:"+fecha).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testDeleteUser() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(UserResource.USERS).path("/{id}").expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadUser() {
        this.createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USERS).path("/{id}").expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":Joaquin,\"birthday\":1991-12-16,\"active\":false}", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test
    public void testReadUserIdNotFoundExeption() {
        exception.expect(HttpException.class);
        this.createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USERS).path("/{id}").expandPath("2").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadUserInvalidExceptionExeption() {
        exception.expect(HttpException.class);
        this.createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USERS).path("/{id}").expandPath("-1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateUserNameEmptyException() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USERS).body(":"+fecha).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateUserDateEmptyException() {
        exception.expect(HttpException.class);
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USERS).body("Joaquin:").build();
        new HttpClientService().httpRequest(request);
    }

}
