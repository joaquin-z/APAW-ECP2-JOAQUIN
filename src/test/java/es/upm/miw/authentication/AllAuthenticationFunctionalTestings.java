package es.upm.miw.authentication;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    UserResourceFunctionalTesting.class,
    AuthenticationResourceFunctionalTesting.class
})
public class AllAuthenticationFunctionalTestings {

}

