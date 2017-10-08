package es.upm.miw.authentication;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.authentication.http.HttpClientService;
import es.upm.miw.authentication.http.HttpMethod;
import es.upm.miw.authentication.http.HttpRequest;
import es.upm.miw.authentication.http.HttpRequestBuilder;

public class UserResourceFunctionalTesting {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        new HttpRequest();
    }

    private void createUser() {
        Calendar date = Calendar.getInstance();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("users").body("Joaquin:"+fecha).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testNewUser() {
         createUser();
    }

}
