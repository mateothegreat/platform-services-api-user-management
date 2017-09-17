package platform.services.api.users;

import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.Collection;

import platform.services.api.UsersConfig;
import platform.services.api.users.authentication.Authorities;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;
import static org.mockito.Mockito.when;

//
// http://junit.org/junit5/docs/current/user-guide/#overview
//
@ExtendWith(MockitoExtension.class)
@ExtendWith(TimingExtension.class)
@ExtendWith(IgnoreIOExceptionExtension.class)
@ContextConfiguration(classes = UsersConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserMockTest implements TestLifecycleLogger {

    @BeforeEach
    public void beforeEach(@Mock final User user) {

        when(user.getUsername()).thenReturn("gibson");

    }

    @Test
    public void usernameIsMocked(@Mock final User user) {

        assertEquals("gibson", user.getUsername());

    }

    @ParameterizedTest
    @EnumSource(Authorities.class)
    void testWithEnumSource(final Authorities authorities) {

        assertNotNull(authorities);

    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {

        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertTrue(true)),
            dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
                            );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {

        return Arrays.asList(
            dynamicTest("3rd dynamic test", () -> assertTrue(true)),
            dynamicTest("4th dynamic test", () -> assertEquals(4, 2 * 2))
                            );

    }

    @Test
    void sleep20ms() throws Exception {

        Thread.sleep(20L);;

        assertTrue(true);

    }

    @Test
    void sleep50ms() throws Exception {

        Thread.sleep(50L);

        assertTrue(true);

    }

}
