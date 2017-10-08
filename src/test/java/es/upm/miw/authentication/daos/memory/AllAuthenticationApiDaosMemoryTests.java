package es.upm.miw.authentication.daos.memory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    UserDaoMemoryTest.class,
    AuthenticationDaoMemoryTest.class
})
public class AllAuthenticationApiDaosMemoryTests {

}
